/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package northwayapp;

import java.awt.CardLayout;
import java.util.*;
import javax.swing.JPanel;

/**
 *
 * @author Rashad
 */
public class CardLayoutManager {
    private CardLayout cl;
    private JPanel parent;
    private List<JPanel> cards;
    private List<String> cardNames;
    private int currentIndex;
    
    /**
     * Pass the parent JPanel and the associated CardLayout
     * @param parent
     * @param cl
     */
    public CardLayoutManager(JPanel parent, CardLayout cl){
        this.cl = cl;
        this.parent = parent;
        this.cards = new ArrayList<>();
        this.cardNames = new ArrayList<>();
        currentIndex = 0;
    }
    
    /**
     * Method to add a new card to the CardLayout in the CardLayoutManager. <b>
     * Don't use this if the card is already added to the CardLayout!</b>
     * @param newCard
     * @param cardName
     */
    public void addCard(JPanel newCard, String cardName){
        cl.addLayoutComponent(newCard, cardName);
        cards.add(newCard);
        cardNames.add(cardName);
    }

    /**
     * Used to add cardNames and cards to the CardLayoutManager when they are
     * already in the CardLayout itself. Make sure to add them in the same
     * order that they were added to the CardLayout, though it doesn't actually
     * matter as long as the CardLayoutManager is used for all controls.
     * @param newCard
     * @param cardName
     */
    public void addCardName(JPanel newCard, String cardName){
        cards.add(newCard);
        cardNames.add(cardName);
    }
    
    /**
     * Switch to and return first card in the stack.
     * @return
     */
    public JPanel first(){
        currentIndex = 0;
        return cards.get(currentIndex);
    }
    /**
     * Switches to next card in layout (or loops back to initial card if at the
     * end of the deck) using the CardLayout.show() method. Returns the newly
     * turned-up card.
     * @return
     */
    public JPanel next(){
        currentIndex += 1;
        if(currentIndex >= cardNames.size()){
            currentIndex = 0;
        }
        cl.show(parent, cardNames.get(currentIndex));
        return cards.get(currentIndex);
    }

    /**
     * Switch to and return card with the given name, or the first card if
     * the name is invalid
     * @param cName
     * @return
     */
    public JPanel show(String cName){
        if(this.cardNames.contains(cName)){
            currentIndex = cardNames.indexOf(cName);
            cl.show(parent, cName);
            return cards.get(currentIndex);
        }
        else return this.first();
    }

    /**
     * Switch to and return the card with the given index if it is within the
     * size of the deck, or the first card if it is not. 
     * @param index
     * @return
     */
    public JPanel show(int index){
        if(index < cardNames.size()){
            currentIndex = index;
            cl.show(parent, cardNames.get(currentIndex));
            return cards.get(currentIndex);
        }
        else return first();
    }
}
