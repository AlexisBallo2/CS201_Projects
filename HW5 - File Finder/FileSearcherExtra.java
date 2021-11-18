import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileSearcherExtra{
	public static BinarySearchTree<Word> myBST = new BinarySearchTree<Word>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File(args[0]);
		System.out.println("Directory:  " + args[0]);
		
		scanFiles(f, "   ");
		//myBST.files(myBST.getRoot());
		boolean var = true;
		scanFiles(f, "    "); //scan all the files and popuate the bst
		while(var) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter a command (a, s, or q)>>");
			char choice = scan.nextLine().charAt(0);
			if(choice == 's') {
				System.out.println("Word to find>>");
				String word = scan.next();
				if(myBST.contains(new Word(word))) {
					Word myword = myBST.find(new Word(word));
					System.out.println(myword);
				} else {
					System.out.println("Sorry! " + word + " is not in this directory!");
				}
				//myBST.individualSearch(myBST.getRoot(), word);  //search all the arrays for the given word
				
				
			
			} else if (choice == 'a') {
				myBST.printTree();
				
			} else {
				System.out.println("good bye!!"); 
				var = false; //stop the loop
			}
		}
		
	}

	public static File scanFiles(File myF, String indent) throws IOException { //scans the files and adds the words to the BST 
		File dir = myF;
		//assign passed file to directory 
		
		
		if(dir == null) //if the file doesnt exist
			return dir;  //return nonesistent file
		if(!dir.isHidden() && dir.getName().charAt(0)!= '.'){
			//if this file exists and is not hidden
			File[] files = dir.listFiles(); //get the sub files of this file/fir
			System.out.println(indent + dir.getName());
			if(files==null) { //if it is a file and not a directory
				if(myBST.contains(new Word(dir.getName()))) {
					myBST.find(new Word(dir.getName())).addFileName(dir.getName());
				} else {
					myBST.insert(new Word(dir.getName()));
					myBST.find(new Word(dir.getName())).addFileName(dir.getName());
				}
				Scanner scan = new Scanner(myF);
				while(scan.hasNext()) { //while the file still has data
					String word = scan.next();
					String myword = word; 
					if(word.contains("."))  //remove the . or , from the word if it is there
						myword = word.split("[.]")[0];
					if(word.contains(","))
						myword = word.split("[,]")[0];
					if(myBST.contains(new Word(myword))) {
						myBST.find(new Word(myword)).setFile(dir.getName());
					} else {
						myBST.insert(new Word(myword));
						myBST.find(new Word(myword)).setFile(dir.getName());
					}
				}
				return myF;
			} else { //if it is a directory
				if(myBST.contains(new Word(dir.getName()))) {
					myBST.find(new Word(dir.getName())).addDir(dir.getName());
				} else {
					myBST.insert(new Word(dir.getName()));
					myBST.find(new Word(dir.getName())).addDir(dir.getName());
				}
				for(int i = 0; i<files.length;i++) {
					 scanFiles(files[i], indent + "    "); //process all the sub files
				}
			}
    	} 
		return null;
	}
	


}


