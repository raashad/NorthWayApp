/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;

import java.awt.Component; // lets me pass general Component to methods(NOT)
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.*; //well, might have to remove the precursor in a lot

/**
 *
 * @author Rashad
 */
public class NavController {
    GUIDrawer drawer;
    Question question;
    Survey survey;
    ValidationTool validator;
    String clientFile;
    
    public NavController(GUIDrawer drawer, Survey survey, String clientFile){
        this(drawer, survey);
        this.clientFile = clientFile;
    }
    public NavController(GUIDrawer drawer, Survey survey){
        this.drawer = drawer;
        this.survey = survey;
        validator = new ValidationTool();
    }
    // Methods for next and so on
    public void next(){
        drawer.increment(1);
    }
    public void previous(){
        drawer.increment(-1);
    }
    public boolean save(){
        boolean saveable = false;
        String line = new String();
        ArrayList<String> tempStrings = new ArrayList<>();
        //first check if the inputs are valid
        switch(drawer.getType()){
            case "TEXTFIELD":
                //for each component, add it to templist, then check if it's
                //valid to decide if we can save it
                for(Component component : drawer.getInputPanel().getComponents()){
                    if(component instanceof JTextField){
                        tempStrings.add(((JTextField)component).getText());
                    }
                }
                saveable = validator.isValid(tempStrings);
                break;
            case "CHECKBOX":
                //if box is checked, add it to templist, and make it saveable
                for(Component component : drawer.getInputPanel().getComponents()){
                    if(component instanceof JCheckBox){
                        if(((JCheckBox)component).isSelected()){
                            tempStrings.add(((JCheckBox)component).getText());
                            // at least one box must be checked
                            saveable = true;
                        }
                    }
                }
                break;
            case "RADIOBUTTON":
                //if box is checked, add it to templist, and make it saveable
                for(Component component : drawer.getInputPanel().getComponents()){
                    if(component instanceof JRadioButton){
                        if(((JRadioButton)component).isSelected()){
                            tempStrings.add(((JRadioButton)component).getText());
                            // at least one box must be checked
                            saveable = true; 
                        }
                    }
                }
                break;
            case "MULTITEXT":
                //needs all valid fields
                for(Component component : drawer.getInputPanel().getComponents()){
                    if(component instanceof JTextField){
                        tempStrings.add(((JTextField)component).getText());
                    }
                }
                //saveable = validator.isValid(tempStrings);
                saveable = validator.isValid(tempStrings);
                break;
                    
        }
        //ave it if possible
        if(saveable) drawer.getQuestion().setAnswer(tempStrings);
        
        return saveable; //return if it saved
    }
    public void saveAndContinue(){
        this.save();
        this.next();
    }
    //actions that do what I want
    class Next extends AbstractAction {
        public Next(){
            super("Save and Continue");       
        }
        @Override
        public void actionPerformed(ActionEvent e){
            //if save is successful, then increment
            if(save()) next();
            //and write to file
            survey.writeToFile(Paths.get(clientFile));
        }
        
    }
    class Previous extends AbstractAction {
        public Previous(){
            super("Previous");
        }
        @Override
        public void actionPerformed(ActionEvent e){
            previous();
        }
    }
    
    class ReDraw extends AbstractAction {
        public ReDraw(String label){
            super(label);
        }
        @Override
        public void actionPerformed(ActionEvent e){
            drawer.redraw();
        }
    }
 
    
    //methods that return appropriate buttons
    public JButton drawNext(){
        JButton temp = new JButton();
        temp.setAction(new Next());
        return temp;
    }
    
    public JButton drawPrevious(){
        JButton temp = new JButton();
        temp.setAction(new Previous());
        return temp;
    }
    public JButton drawUndo(){
        JButton temp = new JButton();
        temp.setAction(new ReDraw("Undo"));
        return temp;
    }
}
