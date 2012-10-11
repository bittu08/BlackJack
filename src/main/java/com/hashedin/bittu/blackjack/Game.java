package com.hashedin.bittu.blackjack;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;



class Game extends Card implements Dealer 
{
	int count=0;
	Boolean gameProgress=false;
	
	Stack<Card> card=new Stack<Card>();
    
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
	}
	
	
	public void shuffleByMyAlgo()
	{

		Map<Integer,Integer> check=new HashMap<Integer, Integer>();
		
		Random rand=new Random();   
		int count=0;
		
		while(count<52)
		{
			int value=rand.nextInt(52);
			int ques=value/13;
			int rem=value%13;
			Card cc=new Card();
			
			if(!check.containsKey(value))
			{
				card.add(cc);
				check.put(value,1);
				count++;
			}
		}
	}

	
	public void initializeGame(Card cc, ScoreSet ss)
	{
		ss.maintainDealerScore(card.pop());
		cc=card.pop();
		System.out.print("Player Card:  "+cc.rank);
		ss.maintainPlayerScore(cc);
		cc=card.pop();
		System.out.print("::"+cc.rank+"\n");
		System.out.println("Player Score::"+ss.maintainPlayerScore(cc));
		
		
	}
	
	public void hit(Card cc,ScoreSet ss) 
	{
		cc=card.pop();
		System.out.println("Player Card After Hit:"+cc.rank);
		System.out.println("Player Score::"+ss.maintainPlayerScore(cc));
		
		return;
		// TODO Auto-generated method stub
		
	}

	public void stand(ScoreSet ss) 
	{
		ss.takeDecision();
		// TODO Auto-generated method stub
		
	}
		
	public void start() throws IOException
	{
		Card cc=new Card();
		ScoreSet ss=new ScoreSet();
		gameProgress=true;
		createDeck();
		Shuffle();
		initializeGame(cc,ss);
		
		while(gameProgress)
		{
			String playerDecision;
			System.out.println("Choose Hit(H)/Stand(S):");
		    Scanner sc=new Scanner(System.in);
			playerDecision=sc.next();
			
				if(playerDecision.equals("H"))
				{ 
					hit(cc,ss);
				}
			
				else if(playerDecision.equals("S"))
				{
					stand(ss);
					gameProgress=false;
					
				}
				else
				{
					System.out.println("Wrong Choice:Choose Valid Choice");
					
					
				}	
		}
	
	}
	
	public void stop()
	{
	
	}

	public void stand() {
		// TODO Auto-generated method stub
		
	}
	
	
}
