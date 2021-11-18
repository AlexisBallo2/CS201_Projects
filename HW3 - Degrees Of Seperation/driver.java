import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class driver {
	
	static ArrayList<Person> peeps = new ArrayList<Person>();
	static ArrayList<Person> exploreList = new ArrayList<Person>();


	public static void main(String[] args) throws IOException {
		String file = "output.txt";
		BufferedWriter out = new BufferedWriter(new FileWriter(file));
		// TODO Auto-generated method stub
		boolean go = true; //set to false to test other thingy
		float total_seps = 0;
		int num_execs = 0;
		readFile("friends.txt");
		while(go) {
			
					
			Scanner scan = new Scanner(System.in);
			//reading the file 
			//readFile("friends-small.txt");
			// System.out.println("test");
			resetPred();
			resetExplored();
			for(int i = 0;i < peeps.size();i++) {
				//if(peeps.get(i).getName().equals("Kevin")|| peeps.get(i).getName().equals("Peg")|| peeps.get(i).getName().equals("Tammy")|| peeps.get(i).getName().equals("Sam"))
				System.out.println(peeps.get(i).getName() + " " + peeps.get(i).getFriendsList());
			}
			Person person1 = new Person();
			Person person2 = new Person();
			boolean hasperson1 = false;
			while(!hasperson1) {
				System.out.println("Enter person1: ");
				String name1 = scan.nextLine();
				boolean p1exists = false;
				for(int i =0; i<peeps.size();i++) {
					if(peeps.get(i).getName().equals(name1)){
						person1 = peeps.get(i);
						p1exists = true;
					} 
				}
				if(p1exists == false) {
					System.out.println("does not exist");
				} else {
					hasperson1 = true;
				}
			}

			boolean hasperson2 = false;
			while(!hasperson2) {
				System.out.println("Enter person2: ");
				String name2 = scan.nextLine();
				boolean p2exists = false;
				for(int i =0; i<peeps.size();i++) {
					if(peeps.get(i).getName().equals(name2)){
						person2 = peeps.get(i);
						p2exists = true;
					} 
				}
				if(p2exists == false) {
					System.out.println("does not exist");
				} else {
					hasperson2 = true;
				}
			}
			Search(person1,person2);
			num_execs++;
			ArrayList<String> my_chain = GetChain(person1,person2);
			System.out.println(my_chain);
			//int seperation = sep(person1,person2);
			//total_seps+= seperation;
			if(my_chain.size()-1 > 0) {
				System.out.println("degrees of seperation = " + (my_chain.size()-1));
				writeChain(out, my_chain);
			} else {
				System.out.println("No connection, or the same person!");
			}
			System.out.println("\n Do you want to go again (y/n) ");
			if(scan.nextLine().charAt(0) == 'y')
				go = true;
			else
				go = false;	
		}
		//System.out.println("\n\nthe average degree of seperation of all computations is "+ total_seps/num_execs);
		
		
		int[][] connectArray = new int[peeps.size()][peeps.size()];
		float total = 0;
		//System.out.println(peeps.size());
		for(int i = 0; i<peeps.size(); i++) {
			//System.out.println(peeps.get(i));
			for(int j = 0; j < peeps.size();j++) {
				resetPred();
				//System.out.println();
				resetExplored();
				resetExploredList();
				//System.out.println(peeps.get(j));
				//System.out.println(i + " " + j);
				if(i == j) {
					connectArray[i][j] = 0;
				} else if((peeps.get(i).getFriendsList().size() == 0) || (peeps.get(j).getFriendsList().size() == 0)) {
						connectArray[i][j] = 1 + peeps.size();
						total += peeps.size() + 1;
						//System.out.println("here");
				} else {
					Search(peeps.get(j),peeps.get(i));
					int num = GetChain(peeps.get(j),peeps.get(i)).size()-1;
					//System.out.println(i + " and " + j);
					connectArray[i][j] = num;
					//System.out.println(connectArray.length);
					total += num;
				}
			}
		}
		float total_sum = 0;
		for(int i = 0; i<peeps.size(); i++) {
			for(int j = 0 ; j < peeps.size();j++) {
				System.out.print(connectArray[i][j]);
				//total_sum += connectArray[i][j];
			}
			System.out.println();
		}
		
		total = total/((peeps.size()*(peeps.size()-1)));
		//float deg = total_sum/((peeps.size()*(peeps.size()-1)));
		System.out.println("average degrees of seperation: " + total);
		writeSEP(out, total);
		out.close();
	}
	
	
	
	
	
	
	public static void Search(Person a, Person b) throws IOException {
		//peeps = new ArrayList<Person>();
		//readFile("friends-small.txt");
		resetPred();
		resetExplored();
		resetExploredList();
		a.setExplored(false);
		// System.out.println(a.getName() + " set explored = false");
		b.setExplored(false);
		// System.out.println(b.getName() + " set explored = false");
		a.setPred(null);
		b.setPred(null);
		boolean found = false; //person B has not been found yet
		exploreList.add(a);
		// System.out.println("adding " + a.getName()+ " to explorelist and \n making this person explored = true");
		a.setExplored(true);
		//if(a.getFriendsList().size() == 0 || b.getFriendsList().size() ==0) {
		//	
		//	return;
		//}
		//System.out.println(exploreList.isEmpty());
		while(exploreList.isEmpty()==false && !found) { //while explorelist is not empty and person has not been found...
			
			Person personX = exploreList.get(0); //get first person from explorelist
			// System.out.println("checking if " + personX.getName() + " == " + b.getName());

			
			if(personX.getName().equals(b.getName())) {
				//they have the same name
				// System.out.println("They do");
				found = true; //person is found
			}
			else {
				//not equal
				// System.out.println("not equal");
				for(int i = 0; i < personX.getFriendsList().size();i++) { //for each person y who is freinds with personx
					int loc = 0;
					for(int j = 0;j<peeps.size();j++) {
						String st1 = peeps.get(j).getName();
						String st2 = personX.getFriendsList().get(i);
						if(st1.equals(st2)) {
							loc = j;
						}
					}
					if(peeps.get(loc).getExplored() == false) { //if personY has not been explored
						exploreList.add(peeps.get(loc)); //add them to explore list
						peeps.get(loc).setExplored(true);
						peeps.get(loc).setPred(personX.getName());
						
					}
					
				}
				exploreList.remove(0);
			}
		}
	}
	public static void readFile(String file) throws IOException{
		Scanner fr = new Scanner(new File(file));
		while(fr.hasNextLine()) {
			String line = fr.nextLine();
			String[] names = line.split("\t"); 
			
			//use the first name to create Person
			Person p = new Person(names[0]);
			
			//rest of names go into friendList
			for(int i = 1;i<names.length;i++) {
				p.getFriendsList().add(names[i]);
			}
			peeps.add(p);
		}
	}
	
	public static Person getPerson(String name) {
		for(int i=0;i<peeps.size();i++) {
				//check if this persons name is the name
				//we are looking for, and if so, return the pwerson
			if(peeps.get(i).getName().equals(name)) {
				return peeps.get(i);
			}
			//if we never found the name return null
			//should never get here but compiler requires this	
		}
		return null;
	}
	public static void resetPred() {
		for(int i =0 ; i<peeps.size();i++) {
			peeps.get(i).setPred(null);
		}
	}
	public static void resetExplored() {
		for(int i =0 ; i<peeps.size();i++) {
			peeps.get(i).setExplored(false);
		}
	}
	public static void resetExploredList() {
		exploreList = new ArrayList<Person>();
	}
	
	public static ArrayList<String> GetChain(Person a, Person b){
		ArrayList<String> chain = new ArrayList<String>();
		Person current = b;
		if(a.getFriendsList().size() == 0 || b.getFriendsList().size() == 0) {
			chain.add(a.getName());
			return chain;
		}
		//System.out.println(a.getName() + " " + a.getFriendsList());
		//System.out.println(b.getName() + " " + b.getFriendsList());
		
		chain.add(0,b.getName());
		//System.out.println("cur person pred " + current.getPred());
		while(current.getPred()!= null) {
			chain.add(0,current.getPred());
			//System.out.println();
			//System.out.println("get pred value: " + current.getPred());
			//System.out.println("currently on " + current.getName() + " and looking for " + current.getPred());
			boolean current_found = false;
			int k = 0;
			while(!current_found) {
				if(peeps.get(k).getName().equals(current.getPred())){    //issue has to be somewhere here
					current = peeps.get(k);
					current_found = true;
				} else {
					k+=1;
				}
				
			}
			//System.out.println(current);
		}
		//if(chain.get(0).equals(a.getName())){
		//	//do nothing
		//}else {
		//	chain.add(0,a.getName());
		//}
		return chain;
		
	}
	public static int sep(Person a, Person b) throws IOException {
		int deg = GetChain(a,b).size()-1;
		Search(a,b);
		//System.out.println("chain method counter gives " + deg);
		
		return deg;
	}
	
	
	public static void writeChain(BufferedWriter out, ArrayList<String> x) throws IOException{
		out.write("queries: \n");	
		for(int i =0;i<x.size();i++) {
			if(i<x.size()-1)
				out.write(x.get(i) + "->");
			else
				out.write(x.get(i));
		}
		out.write("== " + (x.size()-1));
	}
	
	public static void writeSEP(BufferedWriter out,float x) throws IOException {
		out.write("\ndegrees of sep: " + x);
	}
}
