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
    private boolean answerState, isLast;
      
    
    //constructors
    public Question(){
        this("Temporary Name" ,"Test Label", "Text goes here");
        qTypeDictSetUp();
    }
    public Question(String text, String type){
        label = text;
        questionType = type;
        currentAnswer = "";
        
        answerState = false;
        isLast = false;
        qTypeDictSetUp();
    }
    public Question(String qName, String text, String type){
        this(text, type);
        name = qName;  
    }
    //accepts all the info separately, with an arrayList for the last arg
    public Question(
            String qName, String text, String type, ArrayList<String> list){
        this(qName, text, type);
        if(validator.isValid(list)){
            qTypeDict.get(type).addAll(list); 
        } 
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
        return qTypeDict.get(type);
    }
    public boolean isLastQ(){return this.isLast;}
    
    public void setName(String inputText){
        this.name = inputText;
    }
    public void addIntToName(int i){
        this.name = this.name + " " + Integer.toString(i);
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
        answerState = validator.isValid(answer);
        return answerState;
    }
    public boolean setAnswer(ArrayList<String> answers){
        answerList = (ArrayList<String>) answers.clone();
        //use the validation tool to assign answerState
        answerState = validator.isValid(answers);
        isLast = !validator.isValid(answers);
        return answerState;
    }
    public void setList(String type, String ... text){
        //Uses the question type to grab appropriate list, including answers
        qTypeDict.get(type).addAll(Arrays.asList(text));
    }
    public void setLastState(boolean flag) {this.isLast = flag;}
    //method to write string as a line
    public String lineToWrite(String delim){
        String line = new String();
        if (this.isLastQ()) line += LAST;
        line += name;
        for(String answer : answerList){
            line += (";" + answer);
        }
        return line;
    }
    public String lineToWrite(){
        return this.lineToWrite(";");
    }
    public Question clone(){
        //may need to write more appropriate cloning method if this doesnt work
        return this;
    }
}
