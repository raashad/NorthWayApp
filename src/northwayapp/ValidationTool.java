/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;
import java.util.*;
import javax.swing.*;

/**
 * Takes in a value and returns true if it is a valid answer.
 * Can also take a parameter to compare it to
 * @author Rashad
 */
public class ValidationTool {
    String words;
    boolean flag;
    
    public ValidationTool(){
        //I don't think this needs to do anything really
    }
    
    
    public boolean isValid(String input){
        words = input;
        words.replaceAll("\\s", "");
        return !words.equals("");
    }
    
    public boolean isValid(ArrayList<String> input){
        for(String element : input){
            flag = isValid(element); //set flag before checking
            if (!flag) break; //break out of loop if an element is false
        }
        return flag;
        
    }
}
