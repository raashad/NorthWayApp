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

    /**
     *Uses the delimiter string to determine how to break up the lines that
     * are input to populate questions
     * @param delimiter
     */
    public QPopulator(String delimiter){
        delim = "[" + delimiter + "]";
        valid = new ValidationTool();
    }

    /**
     *textLine (usually from quote file) is parsed and passed to Question
     * constructor, which is returned.
     * @param textLine
     * @return
     */
    public Question populate(String textLine){
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
            tempList.get(0), tempList.get(1), (String)tempList.get(2));
    }
    // returns a boolean to tell if we should keep

    /**
     * textLine (usually passed from lines of a text file) are parsed based on
     * internal delimiter. Sets lastState as appropriate. Checks question name
     * against name in the file, and if they match, it passes the rest of the
     * ArrayList to Question.setAnswer. Returns false if there is nothing to
     * pass or if the name is wrong.
     * @param textLine
     * @param question
     * @return
     */
        public boolean populateAnswer(String textLine, Question question){
        
        tempList = new ArrayList<>();
        tempList.addAll(Arrays.asList(textLine.split(delim)));
        if (tempList.get(0).equals(LAST)){
            question.setLastState(true);
            tempList.remove(0);
        }
        else question.setLastState(false);
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
