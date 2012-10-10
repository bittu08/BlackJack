package com.hashedin.bittu.blackjack;
import java.util.*;



public class BlackJackGame {

	public static void main(String args[]) 
	{
		
		Card obj=new Card();
		obj.fnPreprocess();
		
		
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
	
	
	List<HashMap<Integer,Integer>> deck=new ArrayList<HashMap<Integer,Integer>>();
	
    //List<HashMap<Integer,Integer>> deck=new ArrayList<HashMap<Integer,Integer>>();
    
    Map<Integer,Integer> cardSuit=new HashMap<Integer, Integer>();
    
    
	
	public void fnPreprocess()
	{
		
		
		Random rand=new Random();
	    
		int count=0;
		
		while(count<5)
		{
			int value=rand.nextInt(52);
			int ques=value/13;
			int rem=value%13;
		//	deck.add(cardSuit.put(ques, rem), null);
			count++;
		}
		
	    for(int i=0;i<deck.size();i++)
	    {
	    	System.out.println(deck.get(i));
	    }
	
		
		//cardSuit.put(, value)
		///cardSuit.put(Integer.valueOf(0), Integer.valueOf(1));
	
		//deck.add(e)
		//Collections.shuffle(list)
		
	}
  
	
	
}
