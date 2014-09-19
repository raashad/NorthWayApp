/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Rashad
 */
public class FileOperator extends ThompsonTemplate{
    //declare variables
    File quoteSheet, file, notes;
    ValidationTool validator;
    String errorMessage;
        
    //constructors
    public FileOperator(){
        validator = new ValidationTool();
        errorMessage = "ENTER VALID INPUTS!";
        file = null;
        quoteSheet = null;
        notes = null;
        quoteNamesDictSetUp();
        quoteFilesDictSetUp();
    }
    
    //methods
    private boolean setFile(String ext, String ... inputs){
        boolean flag = true; //true unless proven false        
        String fileName = new String(); //used to collect the file names
        for(String element : inputs){
            flag = validator.isValid(element); //is the string validator?
            fileName += element.toLowerCase(); //add string to fileName
            if(!flag) break; //if one of the strings is empty, break out
        }
        if(flag && quoteNamesDict.containsKey(quoteSheet.getName())){
            fileName += quoteNamesDict.get(quoteSheet.getName());
            notes = new File(fileName + ".txt");
            fileName += "." + ext;
            file = new File(fileName); //only set this file if it is validator
        }       
        else file = null;
        return flag;
    }
    public boolean setFile(String ... inputs){
        return FileOperator.this.setFile("txt", inputs); //if no file extension is included
    }
    public boolean fileExists(){
        return file.isFile();
    }
    public boolean notesExists(){
        return notes.isFile();
    }
    public boolean createFile(){
        if(!file.isFile()) try {
            file.createNewFile();
            createNotes();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(FileOperator.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        else return false;
        
    }
    public boolean createNotes(){
        if(!notes.isFile()){
            try {
                notes.createNewFile();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(FileOperator.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        else return false;
    }
    public boolean setQuoteSheet(String input){
        if(input != null) input = input.toUpperCase();
        //this uses the arraylist of quote types in ThompsonTemplate
        if(quoteFilesDict.containsKey(input) 
                && new File(quoteFilesDict.get(input)).isFile()){
            this.quoteSheet = new File(quoteFilesDict.get(input));
            return true;
        }
        else {
            this.quoteSheet = null;
            return false;
        }
    }
    public Survey createSurvey(){
        if(quoteSheet.isFile() && file.isFile()){
            return new Survey(quoteSheet, file);
        }
        else throw new IllegalArgumentException();
    }
    
    public boolean validQuote(){
        return(this.quoteSheet != null);
    }
    public boolean validFile(){
        return(this.file != null);
    }
    public boolean bothValidFiles(){
        return (validQuote() && validFile());
    }
    public String returnError(){
        return errorMessage;
    }
    public String getQuoteName(){
        return quoteSheet.getName();
    }
    public String getFileName(){
        return file.getName();
    }
}
