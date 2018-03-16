package domain;

import java.util.ArrayList;
import java.util.Random;

public class Simulation {
	private Deck deck;
	public Player human, computer;
	boolean endOfGame;
	Card current_card;

	public Simulation() {
		deck = null;
		human = null;
		computer = null;
	}

	public Deck getDeck() {
		return deck;
	}

	public void distributeCards(Player human, Player computer) {

		ArrayList<Card> humanCards = new ArrayList<Card>();
		ArrayList<Card> computerCards = new ArrayList<Card>();

		for (int i = 0; i < deck.getCards().size() / 2; i++) {
			humanCards.add(deck.getCards().get(i));
			computerCards.add(deck.getCards().get(i + 26));
		}

		human.setCards(humanCards);
		computer.setCards(computerCards);

		System.out.println("Game created.Cards are distributed.");
	}

	public int chooseWhoStart() {
		Random rnd = new Random();
		int rnd_number = rnd.nextInt(2);
		if (rnd_number == 0) {
			System.out.println(human.getName() + " start.");
		} else {
			System.out.println(computer.getName() + " starts.");
		}
		return rnd_number;
	}

	public void start() {
		deck = new Deck();
		human = new HumanPlayer();
		computer = new ComputerPlayer();
		distributeCards(human, computer);

	}

}
