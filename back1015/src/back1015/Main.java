package back1015;
import java.util.*;

public class Main {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		data arr[] = new data[N];
		for ( int i = 0 ; i < N ; i++){
			arr[i] = new data();
			arr[i].index = in.nextInt();
		}
		
		int count = 0;
		int min = 10000;
		int savei = 0;
		
		/*for(int i=0;i<N;i++){
		System.out.println(arr[i].index);
		}*/
		
		while ( count < N){
			
			min = 10000;
			
			for ( int i = 0 ; i < N ; i++){
				if ( arr[i].check == false){
					if (arr[i].index < min ){
						min = arr[i].index;
						savei = i;
					}
				}
			}
			
			//System.out.println("saveiÀÔ´Ï´Ù "+savei);
			arr[savei].check = true;
			arr[savei].soonser = count;
			
			count++;
		}
		for(int i=0;i<N;i++){
		System.out.println(arr[i].soonser);
		}
	}
	
	public static class data{
		int index;
		boolean check = false;
		int soonser;
	}
}
