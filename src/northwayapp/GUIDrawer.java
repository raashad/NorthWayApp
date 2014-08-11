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
    final int TEXTSIZE, BOXWIDTH, BOXHEIGHT; //Set the textsize used for outputs
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
        TEXTSIZE = 12;
        BOXWIDTH = 400;
        BOXHEIGHT = 24;
        panel1 = pane1;
        panel2 = pane2;
    }
    
    
    public void drawQuestion(Question toDraw){
        panel1.removeAll();       
        panel1.add(new JLabel(toDraw.getQuestion())); //Draw JLabel
        drawControl(toDraw, toDraw.getType(), panel2);
        panel1.revalidate();
        panel1.repaint();
    }
    
    public void drawControl(Question toDraw, String qType, JPanel pane2){
        panel2.removeAll();
        
        if(qType.equals("TEXTFIELD")){
            Dimension dims = new Dimension(BOXWIDTH, BOXHEIGHT);
            JTextField tempText = new JTextField(toDraw.getAnswer());
            tempText.setAlignmentX(Component.LEFT_ALIGNMENT);
            tempText.setPreferredSize(dims);
            tempText.setMaximumSize(tempText.getPreferredSize());
            pane2.add(tempText);
        }
        else if(qType.equals("CHECKBOX")){
            for(String element : toDraw.getList(qType)){
                pane2.add(new JCheckBox(element));
            }
        }
        else if (qType.equals("RADIOBUTTON")){
            for(String element : toDraw.getList(qType)){
                pane2.add(new JRadioButton(element));
            }
        }
        panel2.revalidate();
        panel2.repaint();
    }
    
    
     
    public void clearPanel(javax.swing.JPanel pane){
        
    }
    
    public <T extends Component> void drawTest(Class<T> item, JPanel pane){
        //Hopefully that fancy stuff up there will let this accept controls
        //pane.add(item);
        // NOPE, NOT WORKING
    }
}
