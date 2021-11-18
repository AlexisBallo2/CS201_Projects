import java.util.ArrayList;

public class Hangman {

	//these are my variables that I need before methods are called
	private int numwords = 10;
	private String[] words = new String[numwords];
	private String gameWord;
	private char[] dispArr = {'-','-','-','-','-','-','-'}; 
	int numincorrect = 0;
	static ArrayList<Character> incorrectGuesses = new ArrayList<Character>();
	


	//this method returns an array of the incorrect guesses made
	public ArrayList<Character> getIncorrectGuesses() {
		return incorrectGuesses;
	}
	
	
	//this method adds an incorrect guess to the array of incorrect guesses
	public void addIncorrectGuess(char g) {
		incorrectGuesses.add(g);
	}
	
	//this method clears the list and makes a new blank list of incorrect guesses
	//for then the next game
	//it also resets the array of letters
	public void newGame() {
		incorrectGuesses = new ArrayList<Character>();
		for(int i=0; i < dispArr.length;i++) {
			dispArr[i]='-';
		}
		numincorrect = 0;
	}
	
	//this method is is getter method for the driver to access the guesses
	public char[] myDispArr() {
		return dispArr;
	}
	
	//this method prints the current state of the guessed word
	public String getCurrentWord(){
		return dispArr[0]+ " " + dispArr[1] +  " " + dispArr[2] +  " " + dispArr[3] +  " " +dispArr[4] + " " + dispArr[5] +  " " + dispArr[6 ] ;
		
	}
	
	//this method prints the current state of the guessed word after making a guess
	public String getCurrentWord(char g, String word){
		for (int i =0;i< word.length();i++) {
			if(word.charAt(i) == g) {
				dispArr[i] = g;
			}
		}
		
		//need to convert dispArr to a string
		return dispArr[0]+ " " + dispArr[1] +  " " + dispArr[2] +  " " + dispArr[3] +  " " +dispArr[4] + " " + dispArr[5] +  " " + dispArr[6 ] ;
		
	}
	
	
	
	//this method selects a game word
	public String selectGameWord() {
		long num = Math.round(Math.random()*10);
		int number = Math.round(num-1);
		setDefaultWords();
		return getWords()[number];
	}
	
	
	
	
	
	//Note that since no constructor is defined, there is 
	//a default empty constructor

	/*Method to display the hangman given the number of body parts to show
	 * Player gets at most 10 turns. */
	public void showMan(int numParts)
	{

		if (numParts == 0){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}
		if (numParts == 1){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}
		if (numParts == 2){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|        |");
			System.out.println("|        |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}

		if (numParts == 3){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|      __|");
			System.out.println("|        |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}
		if (numParts == 4){	
			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|");
			System.out.println("|     	 |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}
		if (numParts == 5){

			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__");
			System.out.println("|     	 |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}
		if (numParts == 6){

			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}
		if (numParts == 7){

			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|       /");
			System.out.println("|      /  ");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}

		if (numParts == 8){

			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|       / \\");
			System.out.println("|      /   \\");
			System.out.println("|");
			System.out.println("|");
			System.out.println("____");
		}

		if (numParts == 9){

			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|       / \\");
			System.out.println("|      /   \\");
			System.out.println("|    O/    ");
			System.out.println("|");
			System.out.println("____");

		}
		if (numParts == 10){

			System.out.println("________");
			System.out.println("|       |");
			System.out.println("|      ____");
			System.out.println("|     / .. \\");
			System.out.println("|    <   .  >");
			System.out.println("|     \\__^_/");
			System.out.println("|        |");
			System.out.println("|     o__|__o");
			System.out.println("|     	 |");
			System.out.println("|       / \\");
			System.out.println("|      /   \\");
			System.out.println("|    O/     \\O");
			System.out.println("|");
			System.out.println("____");
		}

	}

	/**
	  Sets the list of candidate words for the player to guess
	 **/
	public void setDefaultWords()
	{

		this.words[0] = "notions";
		this.words[1] = "measure";
		this.words[2] = "product";
		this.words[3] = "foliage";
		this.words[4] = "garbage";
		this.words[5] = "minutes";
		this.words[6] = "chowder";
		this.words[7] = "recital";
		this.words[8] = "concoct";
		this.words[9] = "brownie";		
	}


	/*********************************************************
	 * Below are the setter and getter methods for this class. 
	 * You may not need to use all the methods but they are included
	 * since it is good practice to have them.
	 *********************************************************/

	/*
	 * Sets the number of words
	 */
	public void setNumWords(int num)
	{
		this.numwords = num;
	}


	/*
	 * Returns the number of words
	 */
	public int getNumWords()
	{
		return this.numwords;
	}


	/*
	 * Sets words array
	 */
	public void setWords(String[] w)
	{
		this.words = w;
	}

	/*
	 * Returns the array of words
	 */
	public String[] getWords()
	{
		return this.words;
	}


	/*
	 * Sets the game word
	 */
	public void setGameWord(String w)
	{
		this.gameWord = w;
		
	}


	/*
	 * Returns the game word
	 */
	public String getGameWord()
	{
		return this.gameWord;
	}


	/*
	 * Sets dispArr
	 */
	public void setDispArr(char[] dA)
	{
		this.dispArr = dA;
	}


	/*
	 * Returns dispArr
	 */
	public char[] getDispArr()
	{
		return this.dispArr;
	}
	

}