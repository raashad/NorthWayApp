/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;
import java.util.*;
import javax.swing.*;
import java.awt.Component;

/**
 *
 * @author Rashad
 */
public class QPopulator extends ThompsonTemplate{
    //declare variables
    String delim;
    ArrayList<String> tempList, tempList2, tempList3;
    Question tempQuestion;
    ValidationTool valid;
    
    //Constructors
    public QPopulator(){
        this(";");
    }
    public QPopulator(String delimiter){
        delim = "[" + delimiter + "]";
    }
    public Question populate(String textLine){
        valid = new ValidationTool();
        tempList = new ArrayList<>();
        tempList2 = new ArrayList<>();
        tempList.addAll(Arrays.asList(textLine.split(delim)));
        //populate the string list
        for(int i = 3; i<tempList.size(); i++){
            tempList2.add(tempList.get(i));
        }        
        //name, label, questionType, then whatever the list will be
        if(valid.isValid(tempList2)){
            return new Question(
                tempList.get(0),
                tempList.get(1),
                tempList.get(2),
                tempList2);
        }
        else return new Question(
            tempList.get(0), tempList.get(1), tempList.get(2));
    }
    // returns a boolean to tell if we should keep
    public boolean populateAnswer(String textLine, Question question){
        valid = new ValidationTool();
        tempList = new ArrayList<>();
        tempList.addAll(Arrays.asList(textLine.split(delim)));
        tempList2 = new ArrayList<>(tempList.subList(1, tempList.size()));
        
        //check if it is the right question to be answering
        if(valid.isNotEmpty(tempList2) 
                && tempList.get(0).equals(question.getName())){
            //not sure if this will work, since I'm not cloning the list...
            question.setAnswer(tempList2);
            return true;
        }
        else return false;
    }
}
