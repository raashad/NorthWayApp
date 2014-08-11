/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;

import java.util.Set;

/**
 *
 * @author Rashad
 */
public class HomeTest {
    //variable declaration
    Question[] questions = new Question[1];
    
    public HomeTest(){
        //questions = new Question[2];
        //questions[0].setQuestion("Hello");
        //questions[1].setQuestion("Goodbye");
        //questions = new Question[1];
        questions[0] = new Question();
        questions[0].setQuestion("Howdy Buddy");
    }
    
    public String getQuestion(){
        return questions[0].getQuestion();
    }
    
    
}
