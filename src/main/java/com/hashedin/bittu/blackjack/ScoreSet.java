package com.hashedin.bittu.blackjack;

class ScoreSet implements Scorer {

	private int playerScore;
	private int dealerScore;

	public void maintainDealerScore(Card sc) {

		dealerScore += sc.rank.getValue();
		// TODO Auto-generated method stub

	}

	public int maintainPlayerScore(Card sc) 
	{
		if (sc.rank.getValue() == 1) 
		{
			if (playerScore <= 11)
				playerScore += sc.rank.getValue();
			else
				playerScore += 10;
		} 
		
		else 
		{
			playerScore += sc.rank.getValue();
		}

		if (playerScore >= 21) 
		{
			takeDecision();
		}
		
		return playerScore;
		// TODO Auto-generated method stub

	}

	public void takeDecision() 
	{

		if (playerScore > 21 || playerScore < dealerScore) {
			System.out.println("*****Result:Dealer Win*******");
		} else if (playerScore == dealerScore) {
			System.out.println("*****Result:Match Drawn*******");
		} else {
			System.out.println("*****Result:Player Win*******");
		}
		// TODO Auto-generated method stub

	}


	public ScoreSet() {
		this.playerScore = 0;
		this.dealerScore = 0;
	}

}
