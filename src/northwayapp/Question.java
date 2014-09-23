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
    private String name, label, questionType, currentAnswer, repeater, defaultName;
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
        repeater = null;
        answerState = false;
        isLast = false;
        qTypeDictSetUp();
    }
    public Question(String qName, String text, String type){
        this(text, type);
        name = qName;
        defaultName = qName;
    }
    //accepts all the info separately, with an arrayList for the last arg
    public Question(
            String qName, String text, String type, ArrayList<String> list){
        this(qName, text, type);
        if(validator.isValid(list)){
            qTypeDict.get(type).addAll(list); 
        } 
    }
    @Override
    public Question clone(){
        return new Question(this.defaultName, 
                this.label, 
                this.questionType, 
                this.fieldsList);
    }
    
    
    //methods to get and set vars
    public String getQuestion(){
        return label;
    }
    public String getAnswer(){
        if(answerList.size() > 0){
            return answerList.get(0);
        }
        else return null;
    }
    public ArrayList<String> getAnswerList(){
        return answerList;
    }
    public boolean getAnswerState(){
        return answerState;
    }
    public int getRepeaterInt(){
        int tempInt = -1;
        if(questionType == "REPEATER"){
            if(answerState) tempInt = Integer.valueOf(getAnswer());
            else tempInt = 1;
        }
        return tempInt;
    }
    public String getType(){
        return questionType;
    }
    public String getName(){
        return name;
    }
    public String getRepeaterPointer(){
        return repeater;
    }
    public ArrayList<String> getList(String type){
        //Uses the question type to grab appropriate list, including answers
        return qTypeDict.get(type);
    }
    public boolean isLastQ(){return this.isLast;}
    
    public void setName(String inputText){
        this.name = inputText;
    }
    public String addIntToName(int i){
        this.name = this.defaultName + " " + Integer.toString(i);
        return this.name;
    }
    public void setQuestion(String inputText){
        label = inputText;
    }
    public void setType(String inputText){
        questionType = inputText;
    }
    public boolean setAnswer(String answer){
        currentAnswer = answer;
        answerList = new ArrayList<>();
        answerList.add(answer);
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
    public void setRepeaterPointer(String repeaterName){
        repeater = repeaterName;
    }

    /**
     *decreases the answer for a repeater type question by one. If it can't be
     * decreased, either due to not being a number, or not being to drop below
     * 1, false is returned.
     * @return
     */
    public boolean decrementRepeater(){
        boolean flag = false;
        int tempInt = this.getRepeaterInt() - 1;
        if(tempInt > 0){
            this.setAnswer(Integer.toString(tempInt));
            flag = true;
        }
        return flag;
    }
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
    
}
