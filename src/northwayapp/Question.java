/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Rashad
 */
public class Question extends ThompsonTemplate{
    //declare variables
    private String name, label, questionType, currentAnswer;
    private int position;
    private boolean answerState;
    private ArrayList<String> textFieldList, checkBoxList, radioButtonList;
    private ArrayList<String> answerList;
    public HashMap<String, ArrayList<String>> dict = new HashMap<>();
    /*//Should be able to eliminate this due to ThompsonTemplate
    public String[] questionTypes = {
        "TEXTFIELD", "CHECKBOX", "RADIOBUTTON", "ANSWERS"};
    ValidationTool valid = new ValidationTool();
    */    
    
    //constructors
    public Question(){
        this("Test Label", "Text goes here");
    }
    public Question(String qName, String text, String type){
        this(text, type);
        name = qName;  
    }
    //accepts all the info separately, with an arrayList for the last arg
    public Question(
            String qName, String text, String type, ArrayList<String> list){
        this(qName, text, type);
        boolean flag = dict.get(type).addAll(list);        
    }
    
    public Question(String text, String type){
        label = text;
        questionType = type;
        currentAnswer = "";
        textFieldList = new ArrayList<>();
        checkBoxList= new ArrayList<>();
        radioButtonList = new ArrayList<>();
        answerList = new ArrayList<>();
        answerState = false;
        //dictSetUp(textFieldList, checkBoxList, radioButtonList, answerList);
        //Should be able to eliminate this due to ThompsonTemplate
        dict.put(questionTypes[0], textFieldList);
        dict.put(questionTypes[1], checkBoxList);
        dict.put(questionTypes[2], radioButtonList);
        dict.put(questionTypes[3], answerList);
        
    }

    /**
     * Used for question types that require a list of entry points.
     * Uses a dictionary mapping the question type to the list that will
     * contain those elements
     * @param text is the text of the question
     * @param type is the question type
     * @param selectable either a button names or starter text for fields
     */
    public Question(String text, String type, String ... selectable){
        this(text, type);
        dict.get(type).addAll(Arrays.asList(selectable));
    }
    
    
    
    //methods to get and set vars
    public String getQuestion(){
        return label;
    }
    public String getAnswer(){
        return currentAnswer;
    }
    public ArrayList<String> getAnswerList(){
        return answerList;
    }
    public boolean getAnswerState(){
        return answerState;
    }
    public String getType(){
        return questionType;
    }
    public String getName(){
        return name;
    }
    public ArrayList<String> getList(String type){
        //Uses the question type to grab appropriate list, including answers
        return dict.get(type);
    }
    
    
    public void setQuestion(String inputText){
        label = inputText;
    }
    public void setType(String inputText){
        questionType = inputText;
    }
    public boolean setAnswer(String answer){
        currentAnswer = answer;
        //use the validation tool to assign answerState
        answerState = valid.isValid(answer);
        return answerState;
    }
    public boolean setAnswer(ArrayList<String> answers){
        answerList = (ArrayList<String>) answers.clone();
        //use the validation tool to assign answerState
        answerState = valid.isValid(answers);
        return answerState;
    }
    public void setList(String type, String ... text){
        //Uses the question type to grab appropriate list, including answers
        dict.get(type).addAll(Arrays.asList(text));
    }
    //method to write string as a line
    public String lineToWrite(String delim){
        String line = new String();
        line += name;
        for(String answer : answerList){
            line += (";" + answer);
        }
        return line;
    }
    public String lineToWrite(){
        return this.lineToWrite(";");
    }
}
