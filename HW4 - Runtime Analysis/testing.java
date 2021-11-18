
public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] integers = new int[100000];
		for(int i =0; i <integers.length;i++) {
			integers[i] = (int) (Math.random()*10);
		}
		
		for(int i = 0;i<integers.length;i++) {
			if(integers[i] == 5) {
				integers[i] = 0;
				System.out.println("Possible?");
			}else {
				System.out.println("not 5");
			}
		}
	}

}
