package hw1;

import java.util.Scanner;

public class TimeConverter {
	
	//I have neither given nor received unauthorized aid on this assignment
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Create a new class/program, TimeConverter.java, 
		 * which takes as user input a number of seconds, 
		 * and prints the equivalent amount of time as a 
		 * combination of hours, minutes, and seconds. 
		 * For example, 9999 seconds is equivalent to 
		 * 2 hours, 46 minutes, and 39 seconds. 
		 * (Do not use if/else or loops for this problem).
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		int secs = scan.nextInt();
		int min = 60;
		int hr = 60*min;
		
		System.out.println(secs/hr + " hours. " + (secs%hr)/min + " minutes. "+ ((secs%hr)%min) + " seconds");
		
		scan.close();
		
				
	}

}
