package domain;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();

	public ArrayList<Card> getCards() {
		return cards;
	}

	public Deck(){
		init();
	}
	
	public void init(){
		createCards();
		shuffle();
	}
	
	public void createCards() {
		for (Suit suit : Suit.values()) {
			for (int i = 1; i < 14; i++) {
				cards.add(new Card(suit, i));
			}

		}
	}

	public void shuffle(){
		for(int i = cards.size()-1; i >= 0; i--){
			Random random = new Random();
			int j = random.nextInt(i+1);
			
			Card card = cards.get(i);
			cards.set(i, cards.get(j));
			cards.set(j, card);
			
		}
	}

}
