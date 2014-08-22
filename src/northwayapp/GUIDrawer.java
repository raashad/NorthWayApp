/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;

import java.awt.Component; // lets me pass general Component to methods(NOT)
import java.util.*;
import javax.swing.*; //well, might have to remove the precursor in a lot
import java.awt.Dimension;

/**
 *
 * @author Rashad
 */
public class GUIDrawer extends ThompsonTemplate{
    //declare objects
    private JPanel panel1, panel2, panel3; // Holds panels to draw in
    int position;
    final int TEXTSIZE, BOXWIDTH, BOXHEIGHT, BUTTONWIDTH; //Set the textsize used for outputs
    Question holdingQuestion;
    Survey survey;
    NavController navigator;
    //public HashMap<String, ArrayList<String>> dict = new HashMap<>();
    
/*  I DONT THINK I NEED THESE!!!
    //declare lists, and I'm initializing them here for fun
    List<javax.swing.JCheckBox> checkBoxList;
    List<javax.swing.JRadioButton> radioButtonList;
    List<javax.swing.JTextField> textFieldList;
    List<javax.swing.JLabel> labelList;
    
    this.labelList = new ArrayList<>();
    this.textFieldList = new ArrayList<>();
    this.radioButtonList = new ArrayList<>();
    this.checkBoxList = new ArrayList<>();
    
*/    
    //Constructors
    public GUIDrawer(Survey survey, JPanel pane1, JPanel pane2, JPanel pane3){
        this(pane1, pane2);
        this.survey = survey;
        panel3 = pane3;
        navigator = new NavController(this, survey, survey.getClientFileName());
        //holdingQuestion = survey.get(position);
        drawQuestion();
    }
    
    public GUIDrawer(JPanel pane1, JPanel pane2){
    //empty constructor to initialize variables and lists, use for others
        this(pane1);
        panel2 = pane2;
    }
    
    public GUIDrawer(JPanel pane1){
        position = 0;
        TEXTSIZE = 12;
        BOXWIDTH = 400;
        BOXHEIGHT = 35;
        BUTTONWIDTH = 100;
        panel1 = pane1;
    }
    
    
    // 'get'ting methods
    public Question getQuestion(){
        return survey.get(position);
    }
    public JPanel getInputPanel(){
        return panel2;
    }
    public String getType(){
        return survey.get(position).getType();
    }
    
    public void redraw(){
        drawQuestion();
    }
    // drawing methods
    private void drawQuestion(){
        panel1.removeAll();       
        panel1.add(new JLabel(getQuestion().getQuestion())); //Draw JLabel
        drawControl(getQuestion(), panel2);
        drawNavButtons(panel3);
        panel1.revalidate();
        panel1.repaint();
    }
    
    public void drawControl(Question toDraw, JPanel pane2){
        panel2.removeAll();
        
        switch (toDraw.getType()) {
            case "TEXTFIELD":
                Dimension dims = new Dimension(BOXWIDTH, BOXHEIGHT);
                JTextField tempText = new JTextField(toDraw.getAnswer());
                tempText.setAlignmentX(Component.LEFT_ALIGNMENT);
                tempText.setPreferredSize(dims);
                tempText.setMaximumSize(tempText.getPreferredSize());
                if(toDraw.getAnswerState()){
                    tempText.setText(toDraw.getAnswerList().get(0));
                }
                pane2.add(tempText);
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
        }
        panel2.revalidate();
        panel2.repaint();
    }

    public void drawNavButtons(JPanel pane){
        pane.removeAll();
        pane.add(navigator.drawPrevious());
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
    
}
