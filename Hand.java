package groupProject;

import java.util.*;

public class Hand {
	public List<Card> hand = new ArrayList<Card>();

    public void addCard(Card c){
        hand.add(c);
    }
    
    public int value()
	{
		int value = 0;
				
		for (Card card : hand){
			value += card.getFace().getValue();								
		}
		return value;
	}
    
    public int size(){
    	return hand.size();
    }
    
    public Card get(int i){
    	return hand.get(i);
    }
    
    public Card remove(int i){
    	return hand.remove(i);
    }
    
    public void newHand() {
    	this.hand.clear();
    }
    
    // I know it's the same as remove, but I don't want to break anyone else's code
    public Card playCard() {
    	return this.remove(0);
    }
}
