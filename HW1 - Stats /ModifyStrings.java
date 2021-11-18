package hw1;

import java.util.Scanner;

public class ModifyStrings {

	//I have neither given nor received unauthorized aid on this assignment 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter phrase");
		String phrase = scan.nextLine();
		int num = scan.nextInt();
		
		System.out.println(phrase.substring(0, num));
		
		scan.close();
	}

}
