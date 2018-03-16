package domain;

public class Card {
	private Suit suit;
	private int number;
	private int score;

	public Card(Suit suit, int number) {
		setSuit(suit);
		setNumber(number);
		setScore(suit, number);

	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getScore() {
		return score;
	}

	public void setScore(Suit suit, int number) {
		int suit_constant = 0;
		switch (suit) {
		case SPADES:
			suit_constant = 5;
			break;
		case HEARTS:
			suit_constant = 7;
			break;

		case DIAMONDS:
			suit_constant = 9;
			break;
		case CLUBS:
			suit_constant = 11;
			break;

		}
		score = number * suit_constant;

	}
}
