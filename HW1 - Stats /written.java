package hw1;


public class written {

	public static void main(String[] args) {

				
		int[] nums = new int[200/4 + 1];
		int count = 0;
		for(int i=0; i<=200;i++) {
			if(i%4==0) {
				nums[count] = i;
				count++;
			}
		}
		
		//part 2
		char[] chars = new char[5];
		chars[1]='a';
		chars[2]='a';
		chars[3]='a';
		chars[4]='a';
		chars[0]='b';
		System.out.println(countFreq(chars,'b'));
	
	
	
	}
	
	
	public static int countFreq(char[] ar, char a) {
		int count = 0;
		for(int i = 0;i<ar.length;i++) {
			if(ar[i]==a) {
				count++;
			}
		}
		return count;
		}


}
