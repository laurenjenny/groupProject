package groupProject
;

public class PokerTest {

	public static void main(String[] args){
		Poker game = new Poker();
		
		game.newGame();
		
		game.theFlop();
		
		game.theTurn();
		
		game.theRiver();
		
		game.determineWinner();
	}
}
