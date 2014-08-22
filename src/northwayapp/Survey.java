/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that contains a list of questions, has operations to grab a certain component
 * @author Rashad
 */
public class Survey {
    //declare variables and lists
    List<String> names;
    List<Question> survey = new ArrayList<Question>(); //DO I NEED TO INITIALIZE???
    QPopulator creationTool;
    //Constructors
    public Survey(ArrayList<Question> questionList){
        //This one takes in a list of questions
        survey = questionList; //just points survey to the passed list
        names = new ArrayList<>();
        //getNamesFromList(); // returns void but auto-populates names
    }
    public Survey(Question singleQuestion){
        //This one takes one question and adds it to survey
        survey = new ArrayList<>(); //remove if initialized at top
        survey.add(singleQuestion);
        //getNamesFromList();
    }
    public Survey(String fileName){
        /* this one will take a text file name and then populate survey
         * by using a Question method to convert the lines of the text file
         * into Questions
         */
        try{
            survey = new ArrayList<>();
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            creationTool = new QPopulator();
            //need to determin
            while(scanner.hasNextLine()){
                survey.add(creationTool.populate(scanner.nextLine()));
            }
            scanner.close();
        }
        catch(FileNotFoundException e){
            System.err.println(
                    "Caught FileNotFoundException: " + e.getMessage());
        }
    }
    
    
    private void getNamesFromList(){
        /*iterates through question list to 
         *grab the question names and adds
         *them to the names list
        */
        names.clear(); // clear the list of all original values
        for (Question element : survey) {
            names.add(element.getName());
        }
    }
    
    public ArrayList<Question> getList(){
        return (ArrayList<Question>)survey;
    }
    
    public Question get(int i){
        return survey.get(i);
    }
    
    public int size(){
        return survey.size();
    }
    
    public void writeToFile(Path path){
        List<String> lines = new ArrayList<>();
        for(Question question : survey){
            lines.add(question.lineToWrite());
        }
        /*
        OutputStream out = Files.newOutputStream(file.toPath());
        for(Question question : this.getList()){
          */
        try {
            Files.write(path, lines);
        } catch (IOException ex) {
            Logger.getLogger(Survey.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
