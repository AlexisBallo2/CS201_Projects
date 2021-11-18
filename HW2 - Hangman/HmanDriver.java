import java.util.Scanner;

public class HmanDriver {

	

	 //create instance of hangman object
	static Hangman game = new Hangman();
	static boolean go = true;
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//while game loop is going
		while(go == true) {
			
			System.out.println("Welcome to hangman!!");
			
			
			//variable for if the player has made a guess or not
			boolean guessed = false;
			
			//choose a word
			System.out.println("Generating your word...");
			String word = game.selectGameWord();
			System.out.println(word);
			
			//while the player has not made 10 incorrect guesses
			//&
			//has not incorrectly guessed a word
			while(game.numincorrect < 10 && guessed == false) {
				printStuff();
				
				System.out.println("l or w?");
				
				char c = getChoice(); //prompt to choose word or letter
				
				
				if(c =='l'|| c == 'L'){ //letter guess
					
					System.out.println("Enter your guess");
					char g = getGuessL(); //get the letter guess
					if(in(g,word)){ //if the guessed letter is in the word
						System.out.println("Correct!");
						game.getCurrentWord(g, word); //populates the letter onto the array
						if(allGuessed()){ // if all of the letters have been successfully guesses
							System.out.println("Winner!!");
							guessed = true; //ends the current play loop
						}
					} else {
						game.addIncorrectGuess(g); //add letter to incorrect guesses
						System.out.println("Incorrect");
						game.numincorrect++; //increase the # of incorrect guesses
						//printStuff();
					}
				} else if (c == 'w'||c=='W') {
					System.out.println("Enter your guess");
					String g = getGuessW();
					if(wordCorrect(g,word)) { //if the word is correct
						System.out.println("Winner!!");
						guessed = false; //stop the loop
						break;
					} else { //if the word is incorrect
						System.out.println("Loser!!, the correct word was: "+ word.toUpperCase()
			);
						guessed = true;
					}
					
				} else {
					System.out.println("not a w or l");
				}
				
			
		
			
			}
			
			if(game.numincorrect == 10) {
				System.out.println("Loser!!, the correct word was: "+ word.toUpperCase());
			}
			System.out.println("Play Again? Y/N: ");
			char again = scan.nextLine().charAt(0);
			if(again=='Y'||again=='y') {
				System.out.println("Restarting...");
				game.newGame();
				guessed=false;
				
			} else if (again=='N') {
				go = false;
				System.out.println("Thanks for playing!");
				break;
			} else {
				System.out.println("Thanks for playing!");
				go=false;
				break;
			}
		}

	}
	
	//this method prints the hangman, the current array of letters, and incorrect guesses
	public static void printStuff() {
		game.showMan(game.getIncorrectGuesses().size()); 
		System.out.println(game.getCurrentWord()); 
		System.out.println("incorrect letters: " + game.getIncorrectGuesses());
	}
	
	
	
	//this method checks if all the letters have been guessed
	public static boolean allGuessed() {
		boolean result = true;
		for(int i = 0;i<game.myDispArr().length;i++) {
			if(game.myDispArr()[i] == '-') {
				result=false;
			}
		}
		return result;
	}
	
	//this method checks if the letter guessed is in the word
	public static boolean in(char a, String s) {
		boolean result = false;
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i)==a) {
				result=true;
			}
		}
		return result;
		
	}
	
	//this method gets the input of letter or word
	public static char getChoice() {
		String a = scan.nextLine();
		return a.charAt(0);
	}
	
	
	//this method gets the letter guess
	public static char getGuessL() {
		String a = scan.nextLine().toLowerCase();
		return a.charAt(0);
	}
	
	//this method gets the guessed word
	public static String getGuessW()  {
		String a = scan.nextLine().toLowerCase();
		return a;
	}
	
	
	//this method checks if the guessed word is correct
	public static boolean wordCorrect(String w,String word) {
		boolean result = false;
		if(w.equals(word)) {
			result = true;
		}
		if(w.toLowerCase().equals(word)) {
			result = true;
		}
		return result;
	}	
}