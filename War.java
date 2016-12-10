package groupProject;

import groupProject.Deck;

public class War {
	
	private Deck deck;
	public Hand player;
	public Hand ai1;
	
	public void startGame() {
		// initialize variables 
		// so we can start with a new deck
		// and hands each new game
		player = new Hand();
		ai1 = new Hand();
		deck = new Deck();
		// randomize deck
		deck.shuffle();
		deal(deck, player, ai1);
		// now lets deal
		
	}
	
	// Just to abstract some logic
	public void deal(Deck deck, Hand player, Hand ai) {
		int deckLength = deck.size() - 1;
		for(int i = 0; i < deckLength; i+= 2) {
			player.addCard(deck.draw(0));
			ai1.addCard(deck.draw(0));
		}
	}
	
	public boolean playRound(Card playerCard, Card ai1Card) {
		
		Card winnerCard =  compareCards(playerCard, ai1Card);
		
		return playerCard.equals(winnerCard);
	}
	
	public Card compareCards(Card card1, Card card2) {
		if (card1.getFace().getValue() > card2.getFace().getValue())
			return card1;
		else if (card1.getFace().getValue() < card2.getFace().getValue())
			return card2;
		else
			return tieBreak(player, ai1);
	}
	
	public void addCards(Card card1, Card card2, Hand hand) {
		hand.addCard(card1);
		hand.addCard(card2);
	}
	
	// recursive method that is called
		// when compareCards results in a tie
		// returns the winning card
		public Card tieBreak(Hand deck1, Hand deck2) {
			// get the next three cards from game decks
			// store them in two temporary hands
			Hand playerTie = new Hand();
			playerTie.addCard(deck1.remove(0));
			playerTie.addCard(deck1.remove(1));
			playerTie.addCard(deck1.remove(2));

			Hand aiTie = new Hand();
			aiTie.addCard(deck2.remove(0));
			aiTie.addCard(deck2.remove(1));
			aiTie.addCard(deck2.remove(2));

			// compare the third card from each hand
			return compareCards(aiTie.hand.get(2), playerTie.hand.get(2));
		}
		
		// method to determine winner1
		public boolean determineWinner() {
			if (player.size() == 0)
				return false;
			else 
				return true;
		}
}
