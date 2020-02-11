/* 
 * Michael Banh
 * Jan 27, 2020
 * CECS 274
 * Cleary 
 */

package Lab01;

import java.util.Scanner;
import java.util.Random;

public class GuessingGame 
{
	public static final Scanner in = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		Random r = new Random();
		int randomNum = r.nextInt(99 + 1);	
		
		System.out.print("I'm thinking of a number. Guess a value (1-100): ");

		int guess = getInt() ;
		
		int count = 1;
		
		while (guess != randomNum)
		{
			while (guess >= 100 || guess <= 0)
			{
				System.out.print("Invalid.\t Guess again: ");
				guess = getInt();
			}
			if (guess > randomNum && guess < 100)
			{
				System.out.print("Too high.\t Guess again: ");
				guess = getInt();
				count++;
			}	
			if (guess < randomNum && guess > 0)
			{
				System.out.print("Too low.\t Guess again: ");
				guess = getInt() ;
				count++;
			}	
		}
		
		System.out.println("Correct!\t You got it in " +count+ " tries");
	}
	
	/**
	 * Checks if the inputted value is an integer.
	 * @return the valid input.
	 */
	public static int getInt()
	{
		int input = 0;
		boolean valid = false;
		
		while( !valid ) 
		{
			if( in.hasNextInt() ) 
			{
				input = in.nextInt();
				valid = true;
			} 
			else 
			{
				in.next(); //clear invalid string
				System.out.print( "Invalid.\t Guess again: " );
			}
		}
		
		return input+1;
	}

}
