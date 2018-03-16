package domain;

import java.util.ArrayList;

public class Player {
	private String name;
	private int score;
	private ArrayList<Card> cards = new ArrayList<Card>();

	public Card getNextCard(Card card) {
		return null;
	}

	public Card getNextCard(int index) {
		return cards.get(index);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName() {
		name = null;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score += score;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public boolean checkEndOfGame(){
		if(cards.size()==0) return true;
		else return false;
	}
	
}
