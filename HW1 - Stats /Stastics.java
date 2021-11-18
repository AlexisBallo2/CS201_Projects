package hw1;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Stastics {

	//I have neither given nor received unauthorized aid on this assignment
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		boolean go = true; //keep going or not
		Scanner scan = new Scanner(System.in);
		
		
		while(go == true) {
			System.out.println("Hello! how many numbers would you like to input?: ");
			int nums = scan.nextInt(); //get num of numbs
			int[] numbers = new int[nums]; 
			for(var j = 0; j<nums;j++) {  //get the nums
				System.out.println("enter number " + (j+1) + ": ");
				numbers[j] = scan.nextInt();
			}
			boolean compute = true; //for computations
			while(compute==true) {
				System.out.println("What would you like to do? \n(1) average \n(2) maximum \n(3) minimum \n(4) range \n(5) mode\n(0) quit");
				int opp = scan.nextInt();
				System.out.println("\n");
				if(opp ==1) {
					System.out.println("the average is: " + average(numbers));
				}
				if(opp ==2) {
					System.out.println("the max is: " +maximum(numbers));
				}
				if(opp ==3) {
					System.out.println("the min is: " +minimum(numbers));
				}
				if(opp ==4) {
					System.out.println("the range is: " + range(numbers));
				}
				if(opp ==5) {
					System.out.println("the mode is: " + mode(numbers));
				}
				if(opp ==0) {
					System.out.println("enter positive intigers(1) or quit(0)");
					int quit = scan.nextInt();
					System.out.println("\n");
					if(quit==1) {
						compute=false;
					} else {
						go = false;
						break;
					}
				}
			}
			
		}
		System.out.println("goodbye!");
		scan.close();
	}
	
	
	//under the main
	
	
	//average 
	public static double average(int[] a) {
		int sum = 0;
		for(int i = 0;i<Array.getLength(a);i++) {
			sum = sum + a[i];
			
			
		}
		double avg = sum/Array.getLength(a);
		return avg;
	}
	
	
	//maximum
	public static int maximum(int[] a) {
		int max = a[0];
		for(int i = 0;i<Array.getLength(a);i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
	
	//minimum
	public static int minimum(int[] a) {
		int min = a[0];
		for(int i = 0;i<Array.getLength(a);i++) {
			if(a[i] < min) {
				min = a[i];
			}
		}
		return min;
	}
	
	//range
	public static int range(int[] a) {
		return (maximum(a)-minimum(a));
	}

	
	//mode -- using a sort of bucket sort
	public static int mode(int[] a) {
		int max = 1;
		int numMostRepeated = 0;
		for(int i = 0;i<Array.getLength(a);i++) {
			if(isin(a,a[i])>max) {
				numMostRepeated = a[i];
			}
		}
		return numMostRepeated;
	}
	
	//method that evaluates how many times each number is in
	public static int isin(int[] a, int b) {
		int times = 0;
		for(int i = 0; i<Array.getLength(a);i++) {
			if(a[i] == b) {
				times++;
			}
		}
		
		return times;
	}
}
