package n01431140_Project2;

import java.util.Scanner;

public class Main {

	/**
	 *  @author Jack Swingle n01431140
	 * Project 2
	 *  
	 * Main: 
	 * creates a chatbot object
	 * prompts user and scans input
	 * passes input to chatbot's interact function
	 * 
	 */
	public static void main(String[] args) {

		String userInput = new String();
		
		Chatbot chatbot1 = new Chatbot();
		
		Scanner input = new Scanner(System.in);
		
		//main loop
		boolean flag = false;
		do 
		{
			System.out.println("Say something:");
			userInput = input.nextLine();
			
			if(userInput.equals("exit")) 
			{
				flag = true; //if user inputs "exit" then loop exits
			} 
			else 
			{
				chatbot1.interact(userInput);
			}
	
		}while(flag == false);//end loop
		
	}//end main

}
