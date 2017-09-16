package back2609;

import java.util.*;

public class Main {

public static void main(String args[]){
	
	Scanner in = new Scanner(System.in);
	int M = in.nextInt();
	int N = in.nextInt();
	int count = 1;
	int idx = 0;
	int save[] = new int[10000];
	while ( true ){
		
		count++;
		if (M%count==0 && N%count==0){
			M = M / count;
			N = N / count;
			save[idx] = count;
			count = 1;
			idx++;
		}
	    int max = M;
	    if (N>max){
	    	max = N;
	    }
		
		if(count > max ){
			break;
		}
	}
	
	int yak = 1;
	for(int i=0;i<idx;i++){
		yak = yak * save[i];
	}
	int gong = yak * M * N;
	
	System.out.println(yak);
	System.out.println(gong);
}
	
}
