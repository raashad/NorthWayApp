/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;
import java.util.*;
/**
 *
 * @author Rashad
 */
public class TestQuestion extends Question{
    Question q1, q2, q3;
    ArrayList<Question> testSurvey = new ArrayList<>();

    public TestQuestion(){
        q1 = new Question("First Question", "TEXTFIELD");
        q2 = new Question("2nd Question", "RADIOBUTTON", "Hello", "Hi","Whats up?");
        q3 = new Question("3rd Question", "CHECKBOX", "Only 2 of us", "You wont see me.");
        
        testSurvey.add(q1);
        testSurvey.add(q2);
        testSurvey.add(q3);
    }
    
    public ArrayList<Question> getSurvey(){
        return testSurvey;
    }
}
