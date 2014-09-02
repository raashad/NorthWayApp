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
public class ThompsonTemplate {
    public static String[] questionTypes = {
        "TEXTFIELD", "CHECKBOX", "RADIOBUTTON", "ANSWERS"};
    public HashMap<String, Object> dict = new HashMap<>();
    //used for quote file names
    
    
    
    
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
      
    
    
    
    
    ValidationTool valid = new ValidationTool();
    Class dictClass;
    
    
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
    // use this to populate the dictionary for any given class
    public boolean dictSetUp(Object ... stuff){
        try{ // try to set up hashmap
            
            
            
            //Convert the Hashmap to applicable type IT WONT LET ME DO THISSSS!!!!!!!!1
          
            
            
            
            dictClass = stuff.getClass(); // holds class for dict
            //dict = new HashMap<String, Class<dictClass>>();
            int i = 0;
            for(Object things : stuff){
                dict.put(questionTypes[i], things);
            }
            return true;
        } //catch if the objects passed go out of bounds of questionTypes
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println(
                    "Went out of bounds on questionTypes[]"+ e.getMessage());
            return false;
        }
    }
    
    // just in case this object stuff doesnt work
    public boolean dictSetUp(ArrayList<String> ... stuff){
        try{ // try to set up hashmap
            int i = 0;
            for(ArrayList<String> things : stuff){
                dict.put(questionTypes[i], things);
            }
            return true;
        } //catch if the objects passed go out of bounds of questionTypes
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println(
                    "Went out of bounds on questionTypes[]"+ e.getMessage());
            return false;
        }
    }
}
