import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class TimeTest {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String[] arg = args;
		File myfile = new File(args[0]); //select the file from the command line arguments
		System.out.println(myfile); //output what file we are using
		Scanner fileReader = new Scanner(myfile); //reader for the file
		fileReader.nextLine(); //throw away the first line 
		String mystr = "hello";
		Scanner scan = new Scanner(System.in);
		boolean go = true; //go loop to let the user keep making new calls 
		while(true) {
			System.out.println("      ADT Menu\n"
					+ "0. Quit\n"
					+ "1. LinkedList (insert at end)\n"
					+ "2. StackArray\n"
					+ "3. StackList\n"
					+ "4. QueueList\n"
					+ "5. ArrayList\n"
					+ "6. array\n"
					+ "" + " your choice - ");
			int num = scan.nextInt();
			if(num == 0) {  //Quit
				System.out.println("Goodbye!");
				return;
			}
			if(num==1) {  //linked list
				long start = System.currentTimeMillis(); //get starting time
				LinkedList<Integer> LL = new LinkedList<Integer>(); //make linkedlist
				while(fileReader.hasNext()) { //get each call
					String myStr = fileReader.next();  //assign each call to the string
					int number = Integer.parseInt(myStr.substring(1));  //take the int from the call
					Integer intNum = number; //convert to Integer for removal
					if(myStr.charAt(0) == 'i') { //if insertion, add to the list, if not, find the index of the element and delete it
						LL.addLast(number);

					} else {
						LL.remove(intNum);  
					}
				}
				System.out.println("total time: " + (System.currentTimeMillis() - start));
			}
			if(num == 2) { //stacked array
				long start = System.currentTimeMillis();
				Stack<Integer> myS= new Stack<Integer>(); //make Stack
				while(fileReader.hasNext()) {
					String myStr = fileReader.next();
					int number = Integer.parseInt(myStr.substring(1));
					if(myStr.charAt(0) == 'i') { 
						myS.push(number); 
					} else {
						myS.pop();
					}
				}
				System.out.println("total time: " + (System.currentTimeMillis() - start) + " millis");
				
			}
			if(num == 3) { //stacked list
				long start = System.currentTimeMillis();
				StackLi myS= new StackLi();
				while(fileReader.hasNext()) {
					String myStr = fileReader.next();
					int number = Integer.parseInt(myStr.substring(1));
					if(myStr.charAt(0) == 'i') {
						myS.push(number);   //O(1)
					} else {
						myS.pop(); //O(1)
					}
				}
				System.out.println("total time: " + (System.currentTimeMillis() - start) + " millis");
			}
			if(num == 4) { //queue list
				long start = System.currentTimeMillis();
				QueueLi myStack = new QueueLi();
				while(fileReader.hasNext()) {
					String myStr = fileReader.next();
					int number = Integer.parseInt(myStr.substring(1));
					if(myStr.charAt(0) == 'i') {
						myStack.enqueue(number);
					} else {
						myStack.dequeue(); //just deque, cannot deque specific number
					}
				}
				System.out.println("total time: " + (System.currentTimeMillis()-start) + " millis");
			}
			if(num == 5) { //array list  
				long start = System.currentTimeMillis();
				ArrayList<Integer> myArray = new ArrayList<Integer>();
				while(fileReader.hasNext()) {
					String myStr = fileReader.next();
					int number = Integer.parseInt(myStr.substring(1));
					Integer numb = number;
					if(myStr.charAt(0) == 'i') {
						myArray.add(numb);
					} else {
						myArray.remove(numb); //- O(n)
					}
				}
				System.out.println("total time: " + (start - System.currentTimeMillis()) + " millis");
			}
			if(num == 6) {  //array
				long start = System.currentTimeMillis();
				int[] myArray = new int[250000];//need to pass size for fixed size array!!
				int counter = 0; //counter variable will determine where we are in the array
				while(fileReader.hasNext()) {
					String myStr = fileReader.next();
					int number = Integer.parseInt(myStr.substring(1));
					if(myStr.charAt(0) == 'i') {
						myArray[counter] = Integer.parseInt(myStr.split("i")[1]);
						counter++;  //increase by 1 to show movement across array
					} else if(myStr.charAt(0) == 'd') {
						for(int i = 0; i < myArray.length;i++) {
							if(number == myArray[i]) {
								myArray[i] = -1;
							}
						} 	
					}
				}
				System.out.println("total time: " + (System.currentTimeMillis() - start) + " millis");
			}
		}
	}

}
