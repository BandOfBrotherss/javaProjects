package domain;

public class HumanPlayer extends Player {

	public HumanPlayer(String name, int score) {
		super();
		setName(name);

	}

	public HumanPlayer() {
		super();
	}

	@Override
	public Card getNextCard(int index) {
		Card card = super.getNextCard(index);
		super.getCards().remove(index);
		return card;
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

}
