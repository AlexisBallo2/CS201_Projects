package hw1;

import java.util.Scanner;

public class HiLo {
	
	//I have neither given nor received unauthorized aid on this assignment
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scan = new Scanner(System.in);
		int guess = 0;
		int endpoint = 0;
		boolean play = true;
		while(play==true) {
			System.out.println("Welcome! Enter integer for end of range (must be > 0): ");
			endpoint = scan.nextInt();
			double num = Math.floor(Math.random()*endpoint + 1);
			boolean going = true;
			while(going==true) {
				
				System.out.println("What is your guess? ");
				guess = scan.nextInt();
				
				if(guess>num) {
					System.out.println("too large");
				} else if (guess<num) {
					System.out.println("too small");
				} else {
					System.out.println("You guessed it");
					going = false;
				}
			}
			System.out.println("would you like to play again? (y/n");
			scan.nextLine();
			char a = scan.nextLine().charAt(0);
			char y = 'y';
			if (a == y) {
				continue;
				
			} else {
				System.out.println("Thanks for playing!!");
				play = false;
				scan.close();
			}
		}
		scan.close();
	}

}
