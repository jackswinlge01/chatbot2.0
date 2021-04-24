package n01431140_Project2;

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Jack Swingle n01431140
 * Project 2
 * 
 * This class creates an object called chatbot
 * it contains a memory object and a constructor that assigns random values to each memory variable
 * it contains reply functions that each print a message
 * it contains a function called interact that calls the reply functions based on user input from main
 * 
 */
public class Chatbot {

	private Memory memory = new Memory();
	
	/**
	 * Chatbot constructor
	 */
	public Chatbot() {
		
		//ArrayList for possible names
		ArrayList<String> pNames = new ArrayList<String>();
		pNames.add("Jack");
		pNames.add("Ben");
		pNames.add("Audrey");
		pNames.add("Brooke");
		pNames.add("Cody");
		
		//ArrayList for possible hobbies
		ArrayList<String> pHobbies = new ArrayList<String>();
		pHobbies.add("reading");
		pHobbies.add("gardening");
		pHobbies.add("video games");
		pHobbies.add("music");
		pHobbies.add("art");
		
		//ArrayList for possible quirks
		ArrayList<String> pQuirks = new ArrayList<String>();
		pQuirks.add("smart");
		pQuirks.add("dumb");
		pQuirks.add("lazy");
		pQuirks.add("strong");
		pQuirks.add("handsome");
		
		//ArrayList for possible favorite DOTWs
		ArrayList<String> pDOTW = new ArrayList<String>();
		pDOTW.add("Monday");
		pDOTW.add("Tuesday");
		pDOTW.add("Wednesday");
		pDOTW.add("Thursday");
		pDOTW.add("Friday");
		pDOTW.add("Saturday");
		pDOTW.add("Sunday");
		
		//ArrayList for possible heights
		ArrayList<Double> pHeights = new ArrayList<Double>();
		pHeights.add(6.0);
		pHeights.add(5.8);
		pHeights.add(5.4);
		pHeights.add(2.0);
		pHeights.add(7.0);
		
		//ArrayList for possible weights
		ArrayList<Integer> pWeights = new ArrayList<Integer>();
		pWeights.add(160);
		pWeights.add(130);
		pWeights.add(200);
		pWeights.add(90);
		pWeights.add(400);
		
		//selects one of the choices for each memory variable randomly
		Random rand = new Random();		
		memory.setName(pNames.get((Math.abs(rand.nextInt() % 5))));
		memory.setQuirk(pQuirks.get((Math.abs(rand.nextInt() % 5))));
		memory.setFavoriteDOTW(pDOTW.get((Math.abs(rand.nextInt() % 7))));
		memory.setFavoriteHobby(pHobbies.get(Math.abs(rand.nextInt() % 5)));
		memory.setHeight(pHeights.get(Math.abs(rand.nextInt() % 5)));
		memory.setWeight(pWeights.get(Math.abs(rand.nextInt() % 5)));
		
	}//end constructor
	
	
	/**
	 * interact function
	 * checks for keywords in user input and calls the appropriate reply function
	 * @param userMessage
	 */
	public void interact(String userMessage) {
		
		String[] splitMessage = userMessage.split(" ");
		int count = 0;
		
		//this loop goes through each word in the user input and checks if it is a keyword
		//if a keyword is found it calls the appropriate reply function
		//if two keywords are found then it returns to main
		for(int i = 0; i < splitMessage.length; i++)
		{
			if(splitMessage[i].toLowerCase().equals("hello")) {
				count++;
				replyHello();
				if(count == 2) {replyAskAboutUser();return;}
			}
			if(splitMessage[i].toLowerCase().equals("name")) {
				count++;
				replyName();
				if(count == 2) {replyAskAboutUser();return;}
			}
			if(splitMessage[i].toLowerCase().equals("favorite")) {
				count++;
				replyFavoriteThings();
				if(count == 2) {replyAskAboutUser();return;}
			}
			if(splitMessage[i].toLowerCase().equals("quirk")) {
				count++;
				replyQuirk();
				if(count == 2) {replyAskAboutUser();return;}
			}
			if(splitMessage[i].toLowerCase().equals("height")) {
				count++;
				replyHeight();
				if(count == 2) {replyAskAboutUser();return;}
			}
			if(splitMessage[i].toLowerCase().equals("weight")) {
				count++;
				replyWeight();
				if(count == 2) {replyAskAboutUser();return;}
			}
		}//end loop
		
		if(count == 0) {
			System.out.println("Sorry, I'm not sure. Try asking me about my name, favorite things, quirk, height, or weight!");
		}//if the user doesn't enter any keywords 
		else {
			replyAskAboutUser();
		}
		
		return;
		
	}//end interact()
	
	
	/**
	 * replyHello()
	 * prints simple hello message
	 */
	private void replyHello() {
		
		System.out.println("Hello!");
		
	}//end replyHello()
	
	
	/**
	 * replyName()
	 * prints chatbot name
	 */
	private void replyName() {
		
		System.out.println("My name is " + memory.getName() + ".");
		
	}//end replyName()
	
	
	/**
	 * replyFavoriteThings()
	 * prints chatbot favorite DOTW and hobby
	 */
	private void replyFavoriteThings() {
		
		System.out.println("I love " + memory.getFavoriteDOTW() + " and " 
		+ memory.getFavoriteHobby() + ".");
		
	}//end replyFavoriteThings()
	
	
	/**
	 * replyQuirk
	 * prints chatbot quirk
	 */
	private void replyQuirk() {
		
		System.out.println("People say I'm " + memory.getQuirk() + ".");
		
	}//end replyQuirk()
	
	
	/**
	 * replyHeight()
	 * prints chatbot height in either feet or meters randomly
	 */
	private void replyHeight() {
		
		Random rand = new Random();
		if(rand.nextInt() < 0) 
		{
			System.out.println("I'm about " + memory.getHeight() + " feet tall.");
		}else {
			System.out.println("I'm about " + Conversion.convertFeetToMeters(memory.getHeight()) + " meters tall.");	
		}
		
		
		
		
	}//end replyHeight()
	
	
	/**
	 * replyWeight()
	 * prints chatbot weight
	 */
	private void replyWeight() {
		
		System.out.println("I weigh about " + memory.getWeight() + " pounds.");
		
	}//end replyWeight()
	
	
	/**
	 * replyAskAboutUser()
	 * prints message asking user about themselves
	 */
	private void replyAskAboutUser() {
		
		System.out.println("What about you? Can you tell me about yourself?");
		
	}//end replyAskAboutUser()
		
}//end class
