package com.hashedin.bittu.blackjack;
import java.io.IOException;



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
			System.out.println("==Enter Wrong Key:Choose Valid Option==");
			
		}
		
		}
	}
}












