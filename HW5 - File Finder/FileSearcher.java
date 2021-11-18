import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileSearcher{
	public static BinarySearchTree<Word> myBST = new BinarySearchTree<Word>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File(args[0]);
		System.out.println("Directory:  " + args[0]);
		
		//scanFiles(f);
		//myBST.files(myBST.getRoot());
		boolean var = true;
		scanFiles(f); //scan all the files and popuate the bst
		while(var) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter a command (a, s, or q)>>");
			char choice = scan.nextLine().charAt(0);
			if(choice == 's') {
				System.out.println("Word to find>>");
				String word = scan.next();
				if(myBST.contains(new Word(word))) { //if the word is in the bst
					Word myword = myBST.find(new Word(word)); //find and return the word 
					System.out.println(myword);
				} else {
					System.out.println("Sorry! " + word + " is not in this directory!");
				}
			} else if (choice == 'a') {
				myBST.printTree();
				
			} else {
				System.out.println("good bye!!"); 
				var = false; //stop the loop
			}
		}
		
	}
	
	
	public static File scanFiles(File myF) throws IOException { //scans the files and adds the words to the BST 
		File dir = myF;
		//assign passed file to directory 
		
		
		if(dir == null) //if the file doesnt exist
			return dir;  //return nonesistent file
		if(!dir.isHidden() && dir.getName().charAt(0)!= '.'){
			//if this file exists and is not hidden
			File[] files = dir.listFiles(); //get the sub files of this file/fir
			if(files==null) { //if it is a file and not a directory
				Scanner scan = new Scanner(myF);
				while(scan.hasNext()) { //while the file still has data
					String word = scan.next();
					String myword = word; 
					if(word.contains("."))  //remove the . or , from the word if it is there
						myword = word.split("[.]")[0];
					if(word.contains(","))
						myword = word.split("[,]")[0];
					if(myBST.contains(new Word(myword))) {//if the word is already in the tree
						myBST.find(new Word(myword)).setFile(dir.getName());  //find the word and add the file to the arrray
					} else { //if the word is not in the tree
						myBST.insert(new Word(myword)); //add the word to the tree
						myBST.find(new Word(myword)).setFile(dir.getName()); //add the file
					}
				}
				return myF;
			} else { //if it is a directory
				for(int i = 0; i<files.length;i++) {
					 scanFiles(files[i]); //process all the sub files
				}
			}
    	} 
		return null;
	}
	


}


