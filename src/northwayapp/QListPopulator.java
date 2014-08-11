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
public class QListPopulator extends ThompsonTemplate{
    // Declare variables
    String file, delim;
    List<Question> list;
    
    //Constructors
    public QListPopulator(String filePath, ArrayList<Question> questionList){
        file = filePath;
        list = questionList;
        
        
    }
}
