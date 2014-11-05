/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;

import java.awt.Component; // lets me pass general Component to methods(NOT)
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*; //well, might have to remove the precursor in a lot
import northwayapp.NavController.Next;

/**
 *
 * @author Rashad
 */
public class GUIDrawer extends ThompsonTemplate{
    //declare objects
    private JPanel panel1, panel2, panel3; // Holds panels to draw in
    int position, labelHeight, fieldHeight;
    
    Question holdingQuestion;
    Survey survey;
    NavController navigator;
    NavController.Next nextAction;
    Font labelFont, fieldFont;
    JComboBox navComboBox;
      
    //Constructors
    public GUIDrawer(Survey survey, JPanel pane1, JPanel pane2, JPanel pane3, JComboBox cb){
        this(pane1, pane2);
        this.survey = survey;
        panel3 = pane3;
        navigator = new NavController(this, survey, survey.getClientFileName());
        position = this.survey.getLastQuestionIndex();
        this.navComboBox = cb;
        //used to create an instance of the NavC innerclass Next
        nextAction = navigator.new Next();
        drawQuestion();
    }
    
    public GUIDrawer(JPanel pane1, JPanel pane2){
    //empty constructor to initialize variables and lists, use for others
        this(pane1);
        panel2 = pane2;
    }
    
    public GUIDrawer(JPanel pane1){
        labelFont = new Font(FONTNAME, Font.PLAIN, TEXTSIZE);
        fieldFont = new Font(FONTNAME, Font.PLAIN, FIELDTEXTSIZE);
        labelLabel = new JLabel();
        fieldLabel = new JLabel();
        labelLabel.setFont(labelFont);
        fieldLabel.setFont(fieldFont);
        metLabel = labelLabel.getFontMetrics(labelFont);
        metField = fieldLabel.getFontMetrics(fieldFont);
        labelHeight = metLabel.getHeight() + 10;
        fieldHeight = metField.getHeight() + 10;
        
        position = 0;
        panel1 = pane1;
        
    }
    
    public boolean isLastCopy(Question question){
        boolean flag = false;
        String repeater = question.getRepeaterPointer();
        if(repeater != null){
            int numReps = Integer.valueOf(survey.get(repeater).getAnswer());
            int repPos = survey.getIndex(question.getName()) - survey.getIndex(repeater);
            if(numReps == repPos) flag = true;
        }
        return flag;
    }
    // 'get'ting methods
    public Question getQuestion(){
        return survey.get(position);
    }
    public JPanel getInputPanel(){
        return panel2;
    }
    public String getName(){
        return survey.get(position).getName();
    }
    public String getType(){
        return survey.get(position).getType();
    }
    public int getPosition(){
        return this.position;
    }
    public int getReps(){
        String tempString;
        try{
            tempString = survey.get(position).getAnswerList().get(0);
        }catch(IndexOutOfBoundsException e){
            System.err.println("There's no answer yet");
            tempString = Integer.toString(1);
        }
        if(validator.isValid(tempString)){
            try{
                return Integer.valueOf(tempString);
            }catch (NumberFormatException e){
                return 2;
            }
        }
        else return 3;
    }
    public void redraw(){
        drawQuestion();
    }
    // drawing methods
    private void drawQuestion(){
        panel1.removeAll();  
        JLabel temp = new JLabel(getQuestion().getQuestion());
        temp.setFont(labelFont);
        panel1.add(temp); //Draw JLabel
        drawControl(getQuestion(), panel2);
        drawNavButtons(panel3);
        navigator.setComboBox(navComboBox);
        panel1.revalidate();
        panel1.repaint();
    }
    
    public void drawControl(Question toDraw, JPanel pane2){
        panel2.requestFocusInWindow();
        panel2.removeAll();
        JTextField focusField = new JTextField();
        JTextField lastField = new JTextField();
        switch (toDraw.getType()) {
            case "TEXTFIELD":
                Dimension dims = new Dimension(BOXWIDTH, fieldHeight);
                JTextField tempText = new JTextField(toDraw.getAnswer());
                tempText.setAlignmentX(Component.LEFT_ALIGNMENT);
                tempText.setPreferredSize(dims);
                tempText.setMaximumSize(tempText.getPreferredSize());
                if(toDraw.getAnswerState()){
                    tempText.setText(toDraw.getAnswerList().get(0));
                }
                pane2.add(tempText);
                focusField = tempText;
                lastField = tempText;
                break;
            case "CHECKBOX":
                //for each element in the checkbox question list
                for(String element : toDraw.getList(toDraw.getType())){
                    //make a new checkbox
                    JCheckBox tempCheckBox = new JCheckBox(element);
                    //and check it if it's in the answerlist
                    if(toDraw.getAnswerList().contains(element)){
                        tempCheckBox.setSelected(true);
                    }
                    pane2.add(tempCheckBox);
                }   break;
            case "RADIOBUTTON":
                ButtonGroup buttonGroup = new ButtonGroup();
                //for each element in the radiobutton question list
                for(String element : toDraw.getList(toDraw.getType())){
                    //make a new radiobutton
                    JRadioButton temp = new JRadioButton(element);
                    buttonGroup.add(temp);
                    //if it is in the answerlist, set it as checked
                    if(toDraw.getAnswerList().contains(element)){
                        temp.setSelected(true);
                    }
                    pane2.add(temp);
                }   break;
            case "MULTITEXT":
                int i = 0;
                for(String element : toDraw.getList(toDraw.getType())){
                    JLabel tempLabel = new JLabel(element);
                    tempLabel.setFont(labelFont);
                    JTextField tempField = new JTextField();
                    tempField.setFont(fieldFont);
                    tempField.setAlignmentX(Component.LEFT_ALIGNMENT);
                    //clunky method to set width of textbox
                    Dimension tempDims = new Dimension(
                            (FIELDPANELSIZE 
                            - (metLabel.stringWidth(tempLabel.getText())
                            + metLabel.charWidth('c')*2)),
                            fieldHeight);
                    tempField.setPreferredSize(tempDims);
                   
                    pane2.add(tempLabel);
                    pane2.add(tempField);
                    if(i == 0) focusField = tempField;
                    if(i == toDraw.getList(toDraw.getType()).size()-1){
                        lastField = tempField;
                    }
                     if(toDraw.getAnswerState()){
                        tempField.setText(toDraw.getAnswerList().get(i));
                    }
                    i += 1;
                }   break;
            case "REPEATER":
                int startingInt = 1;
                if(toDraw.getAnswerState()){
                    startingInt = Integer.valueOf(toDraw.getAnswerList().get(0));
                }
                int arraySize = 5;
                String[] choices = new String[arraySize];
                for (int x = 0; x < arraySize; x++){
                    choices[x] = String.valueOf(startingInt + x);
                }
                JComboBox cb = new JComboBox(choices);
                pane2.add(cb);
                break;
        }
        panel2.revalidate();
        panel2.repaint();
        focusField.requestFocus();
        
        
        lastField.setAction(nextAction);
    }
    
    public void actionPerformed(ActionEvent evt){
        navigator.saveAndContinue();
    }

    public void drawNavButtons(JPanel pane){
        pane.removeAll();
        pane.add(navigator.drawPrevious());
        /*if(getQuestion().getRepeaterPointer() != null){
            pane.add(navigator.drawRemoveQuestion());
        }*/
        pane.add(navigator.drawUndo());
        pane.add(navigator.drawNext());
               
        pane.revalidate();
        pane.repaint();
    }

    
    public void increment(int i){
        position += i;
        if(position < 0 || position >= survey.size()) position = 0;
        drawQuestion();
    }
    public void jumpTo(int i){
        position = i;
        drawQuestion();
    }
    public void jumpTo(String name){
        this.jumpTo(survey.getIndex(name));
    }
    public void jumpToLast(){
        position = survey.getLastQuestionIndex();
        drawQuestion();
    }
    
    class RemoveRepeatedQuestion extends AbstractAction{
        int indexToRemove = -1;
        public RemoveRepeatedQuestion(){
            super("DELETE");
            indexToRemove = position;
        }
        public RemoveRepeatedQuestion(int idx){
            this();
            indexToRemove = idx;
        }
        
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                if(survey.remove(indexToRemove)){}
                else{
                    JOptionPane.showMessageDialog(panel2, 
                            "This is probably the only one...", 
                            "Can't remove question", 
                            JOptionPane.WARNING_MESSAGE);
                        
                }
            }catch(NullPointerException a){
                System.err.println("RemoveRepeatedQuestion action is not pointing at anything" + a.getMessage());
            }
        }
    }
}
