/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Rashad
 */
public class ThompsonTemplate {
    //Constants to set sizes of fields
    final int FIELDPANELSIZE = 500;
    final int TEXTSIZE = 18;
    final int FIELDTEXTSIZE = 14;
    final int BOXWIDTH = 500;
    final int BOXHEIGHT = FIELDTEXTSIZE + 20;
    final int BUTTONWIDTH = 100; //Set the textsize used for outputs
    final String FONTNAME = "Cambria";
    //Font labelFont = new Font(FONTNAME, Font.PLAIN, TEXTSIZE);
    //Font fieldFont = new Font(FONTNAME, Font.PLAIN, FIELDTEXTSIZE);
    Font labelFont;
    Font fieldFont;
    JLabel labelLabel, fieldLabel;
    //Graphics gLabel, gField;
    FontMetrics metLabel, metField;
    
    public void setUpFontMetrics(){
        this.labelFont = new Font(FONTNAME, Font.PLAIN, TEXTSIZE);
        this.fieldFont = new Font(FONTNAME, Font.PLAIN, FIELDTEXTSIZE);
        this.labelLabel = new JLabel();
        this.fieldLabel = new JLabel();
        this.labelLabel.setFont(labelFont);
        this.fieldLabel.setFont(fieldFont);
        this.metLabel = labelLabel.getFontMetrics(labelFont);
        this.metField = fieldLabel.getFontMetrics(fieldFont);
    }
            
    //This sets up the dictionary of quote types associated with lists
    public static String[] questionTypes = {
        "TEXTFIELD", "CHECKBOX", "RADIOBUTTON", "ANSWERS", "MULTITEXT"};
    public HashMap<String, ArrayList<String>> qTypeDict = new HashMap<>();
    //used for quote file names
    ArrayList<String> textFieldList, checkBoxList, radioButtonList;
    ArrayList<String> answerList;
    public void qTypeDictSetUp(){
        qTypeDict = new HashMap<>();
        textFieldList = new ArrayList<>();
        checkBoxList= new ArrayList<>();
        radioButtonList = new ArrayList<>();
        answerList = new ArrayList<>();
        
        qTypeDict.put(questionTypes[0], textFieldList);
        qTypeDict.put(questionTypes[1], checkBoxList);
        qTypeDict.put(questionTypes[2], radioButtonList);
        qTypeDict.put(questionTypes[3], answerList);
        qTypeDict.put(questionTypes[4], textFieldList);
    }
    
    public final static String[] QUOTES = {
        "AUTO",
        "HOME"
    };
    public final static String[] QUOTE_FILES = {
        "auto_quote.txt",
        "home_quote.txt"
    };
    final static List<String> quoteFileNames 
            = new ArrayList<>(Arrays.asList(QUOTE_FILES));   
    public HashMap<String, String> quoteNamesDict = new HashMap<>();
    public HashMap<String, String> quoteFilesDict = new HashMap<>();
      
    public final static String LAST = "LAST";
    ValidationTool validator = new ValidationTool();
       
    public void quoteNamesDictSetUp(){
        for(int i = 0; i < quoteFileNames.size(); i++){
            quoteNamesDict.put(QUOTE_FILES[i], QUOTES[i]);
        }
    }
    public void quoteFilesDictSetUp(){
        for(int i = 0; i < quoteFileNames.size(); i++){
            quoteFilesDict.put(QUOTES[i], QUOTE_FILES[i]);
        }
    }    
    }
