package com.hashedin.bittu.blackjack;

class Card {
	public enum Rank {
		ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(
				9), TEN(10), JACK(10), QUEEN(10), KING(10);

		private int value;

		Rank(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}

	public enum Suit {
		CLUB(0), SPADES(1), DIAMOND(2), HEARTS(3);

		private int value;

		Suit(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

	}

	public Suit suit;
	public Rank rank;

	public Card() {
	}

	public Card(Suit a, Rank b) {
		this.suit = a;
		this.rank = b;
		// suit.getValue();
		// this.rank=Rank.valueOf(toString(b));
		// System.out.println("Value: "+suit.getValue()+":"+rank.getValue());
	}

}
