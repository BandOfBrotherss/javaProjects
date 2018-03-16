package domain;

import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer extends Player {

	public ComputerPlayer(int score, ArrayList<Card> cards) {
		super();
		setName();
		setCards(cards);

	}
	
	public ComputerPlayer() {
		super();
	}

	@Override
	public void setName() {
		Random random = new Random();
		String name = "computerPlayer#" + random.nextInt(10);
		super.setName(name);
	}
	
	@Override
	public Card getNextCard(Card current_card){
		Card selected_card = null;
		for (Card card : super.getCards()){
			if(current_card.getScore()<card.getNumber()){
				selected_card = card;
				break;
			}else{
				selected_card = card;
			}
		}
		for (Card card : super.getCards()){
			if(card.equals(selected_card)){
				super.getCards().remove(card);	
				
			}
			
		}
		
		
		return selected_card;
		
	}

	
		
		
	
	
	
}
