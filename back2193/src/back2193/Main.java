package back2193;

import java.util.*;

public class Main {

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		long ICHIN[] = new long[91];
		
		ICHIN[1] = 1;
		ICHIN[2] = 1;
		
		for(int i=3 ; i< 91 ; i++){
			ICHIN[i] = ICHIN[i-1] + ICHIN[i-2];
		}
		
		System.out.println(ICHIN[N]);

		
	}
	
}
