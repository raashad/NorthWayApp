/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;

/**
 *
 * @author Rashad
 */
public class NavController {
    GUIDrawer drawer;
    
    public NavController(GUIDrawer drawer){
        this.drawer = drawer;
    }
    // Methods for next and so on
    public void next(){
        drawer.increment(1);
    }
    public void previous(){
        drawer.increment(-1);
    }
    public boolean save(){
        //first check if the inputs are valid
        //then save it if possible
        return false; //return if it saved
    }
    public void saveAndContinue(){
        
    }
}
