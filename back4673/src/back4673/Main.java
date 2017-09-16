package back4673;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    
	
	public static void main(String args[]){

	
	int d[] = new int[12000];
	
	int count = 1;

	while ( true ){
	
	int result = makeself(count);
	if ( count == 10000){ break; }
	d[result] = 1;
	count++;
		
	}

	
	for(int i = 1 ; i<10000;i++){
		if (d[i]== 0 )
    System.out.println(i);
	}
	
	
	}
	
	public static int  makeself(int x){
		
		int pivot = 10000;
		int sum = x;
		while ( pivot >= 1){
			
			int one = x / pivot;
			x = x % pivot;
			sum = sum + one;
			pivot /= 10;
		}
		
		return sum;
		
	}
	
	
}
