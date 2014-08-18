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
    private JPanel panel1, panel2; // Holds panels to draw in
    final int position, TEXTSIZE, BOXWIDTH, BOXHEIGHT, BUTTONWIDTH; //Set the textsize used for outputs
    Question holdingQuestion;
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
    public GUIDrawer(JPanel pane1, JPanel pane2){
    //empty constructor to initialize variables and lists, use for others
        this(pane1);
        panel2 = pane2;
    }
    
    public GUIDrawer(JPanel pane1){
        position = 0;
        TEXTSIZE = 12;
        BOXWIDTH = 400;
        BOXHEIGHT = 24;
        BUTTONWIDTH = 100;
        panel1 = pane1;
    }
    
    
    public void drawQuestion(Question toDraw){
        panel1.removeAll();       
        panel1.add(new JLabel(toDraw.getQuestion())); //Draw JLabel
        drawControl(toDraw, toDraw.getType(), panel2);
        panel1.revalidate();
        panel1.repaint();
    }
    
    public void drawControl(Question toDraw, JPanel pane2){
        panel2.removeAll();
        
        if(toDraw.getType().equals("TEXTFIELD")){
            Dimension dims = new Dimension(BOXWIDTH, BOXHEIGHT);
            JTextField tempText = new JTextField(toDraw.getAnswer());
            tempText.setAlignmentX(Component.LEFT_ALIGNMENT);
            tempText.setPreferredSize(dims);
            tempText.setMaximumSize(tempText.getPreferredSize());
            pane2.add(tempText);
        }
        else if(toDraw.getType().equals("CHECKBOX")){
            for(String element : toDraw.getList(toDraw.getType())){
                pane2.add(new JCheckBox(element));
            }
        }
        else if (toDraw.getType().equals("RADIOBUTTON")){
            ButtonGroup buttonGroup = new ButtonGroup();
            for(String element : toDraw.getList(toDraw.getType())){
                JRadioButton temp = new JRadioButton(element);
                buttonGroup.add(temp);
                pane2.add(temp);
            }
        }
        panel2.revalidate();
        panel2.repaint();
    }
    /*
    public void drawNavButtons(Question toDraw){
        if(toDraw.getAnswerState()){
            JButton nextSave = newJButton("Save and Continue");
            JButton previous = newJButton("Previous");
            
        }
    }
    */
    public void increment(int i){
        position += i;
    }
    
}
