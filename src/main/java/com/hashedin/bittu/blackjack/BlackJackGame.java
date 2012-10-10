package com.hashedin.bittu.blackjack;
import java.io.IOException;
import java.util.*;


interface Dealer {
	
	public void Shuffle();
	public HashMap<Integer,Integer> hit();
	public void stand();

}

interface PlayerInterface
{
	public void getHitCard();
	
}

interface Scorer
{
	
	public void maintainDealerScore();
	public void maintainPlayerScore();
	public void takeDecision();
	
	
}

public class BlackJackGame {

	public static void main(String args[]) throws IOException 
	{
		System.out.println("==Welcome To BlackJack Game==");
		
		Boolean gameProgress=false;
		
		System.out.println("Enter (Y/N) to start game:");
		
		
		char gameStart=(char) System.in.read();
		
	    
		switch(gameStart)
		{
		case 'Y':
		{
			gameProgress=true;
			Game game=new Game();
			game.createDeck();
			game.start();
			break;
			
		}
		case 'N':
		{
			gameProgress=false;
			System.out.println("==Thank You==");
			break;
		}
		
		default:
		{
			System.out.println("Enter Wrong Key:");
		}
		
		}
		
		
		
		//Card obj=new Card();
		//obj.fnShuffle();	
	}
}


class Card
{
	public enum Rank
	{
		ACE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(10),QUEEN(10),KING(10);
	
		private int value;
		
		Rank(int value)
		{
		this.value=value;
		}
		public int getValue(){return value;}
	
	}
	
	public enum Suit
	{
		CLUB(0),SPADES(1),DIAMOND(2),HEARTS(3);
	
		private int value;
		
	    Suit(int value)
		{
		this.value=value;
		}
	    
		public int getValue(){return value;}
	
	
	}
	
	public Suit suit;
	public Rank rank;
	
	public Card(){}
	public Card(Suit a,Rank b)
	{
		this.suit=a;
		this.rank=b;
	//	suit.getValue();
		//this.rank=Rank.valueOf(toString(b));
		//System.out.println("Value: "+suit.getValue()+":"+rank.getValue());
	}
	
	
	
}



class Game extends Card implements Dealer 
{
	int count=0;
	Boolean gameProgress=false;
	
	Stack<Card> card=new Stack<Card>();
	
	List<HashMap<Integer,Integer>> deck=new ArrayList<HashMap<Integer,Integer>>();
    Map<Integer,Integer> cardSuit;
    
    
    public void createDeck()
    {
    	for(Suit s:Suit.values())
    	{
    		for(Rank r:Rank.values())
    		{
    			Card cc=new Card(s,r);
    			card.add(cc);
    		}
    	}
    }
    
	public void Shuffle()
	{
		
		Collections.shuffle(card);
		
		/*Map<Integer,Integer> check=new HashMap<Integer, Integer>();
		
		Random rand=new Random();   
		int count=0;
		
		while(count<52)
		{
			cardSuit=new HashMap<Integer, Integer>();
			int value=rand.nextInt(52);
			int ques=value/13;
			int rem=value%13;
			if(!check.containsKey(value))
			{
				cardSuit.put(ques, rem);
				deck.add((HashMap<Integer, Integer>) cardSuit);
				check.put(value,1);
				count++;
			}
		}*/
		
		
	}

	
	public HashMap<Integer,Integer> hit() 
	{
		
		return (HashMap<Integer, Integer>) (deck.get(count));		
		// TODO Auto-generated method stub
		
	}

	public void stand() 
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	public void start() throws IOException
	{
		Card cc=new Card();
		ScoreSet ss=new ScoreSet();
		gameProgress=true;
		Shuffle();
		ss.maintainDealerScore(card.pop());
		cc=card.pop();
		System.out.println("Player Card:"+cc.rank);
		ss.maintainPlayerScore(cc);
		cc=card.pop();
		System.out.println(","+cc.rank);
		ss.maintainPlayerScore(cc);
	     
		
		while(gameProgress)
		{
			String playerDecision;
			System.out.println("Choose Hit(H)/Stand(S):");
		    Scanner sc=new Scanner(System.in);
			playerDecision=sc.next();
			
				if(playerDecision.equals("H"))
				{ 
					cc=card.pop();
					ss.maintainPlayerScore(cc);
					System.out.println("Player Card:"+cc.rank);
					
				}
			
				else if(playerDecision.equals("S"))
				{
					ss.takeDecision();
					gameProgress=false;
					
				}
				else
				{
					System.out.println("Wrong Choice:");
				}
			
			
			
			
			
			
			
		}
		
		
		
	}
	
	public void stop()
	{
	
	}
	
	
}



class Player implements PlayerInterface
{

	public void getHitCard() {
		// TODO Auto-generated method stub
		
	}

}

class ScoreSet implements Scorer
{

	private int playerScore;
	private int dealerScore;
	
	public void maintainDealerScore(Card sc) {
		
		dealerScore+=sc.rank.getValue();
		// TODO Auto-generated method stub
		
	}

	public void maintainPlayerScore(Card sc) {
		playerScore+=sc.rank.getValue();
		System.out.println("PlayerScore:"+playerScore);
		
		if(playerScore >=21)
		{
			takeDecision();
		}
		// TODO Auto-generated method stub
		
	}

	public void takeDecision() {
		
		
		if(playerScore>21 || playerScore <dealerScore)
		{
			System.out.println("Dealer Win");
		}
		else if(playerScore==dealerScore)
		{
			System.out.println("Math Drawn");
		}
		else
		{
			System.out.println("Player Win");
		}
		// TODO Auto-generated method stub
		
	}

	public void maintainDealerScore() {
		// TODO Auto-generated method stub
		
	}

	public void maintainPlayerScore() {
		// TODO Auto-generated method stub
		
	}
	
	public ScoreSet()
	{
		this.playerScore=0;
		this.dealerScore=0;
	}

	
	
}




