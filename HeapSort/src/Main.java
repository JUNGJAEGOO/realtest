import java.util.*;
public class Main {
static int Arr[];
static boolean Fix[];
static int cnt = 0;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("N(배열의 크기) 를 입력해주세요.");
		int N = in.nextInt();
		Arr = new int[N+1];
		Fix = new boolean[N+1];
		System.out.println("배열의 요소들 입력 하세요.");
		for ( int i = 1 ;i <= N ; i++){
			Fix[i] = false;
			Arr[i] = in.nextInt();
		}

	    int HeapLength = (int) (Math.log(Arr.length-1)/Math.log(2));
		while( true )
		{
	    cnt = 0;
			for( int i = (int) (Math.pow(2,HeapLength)-1) ; i >= 1 ; i--)
			{
			MakeHeap(i,2*i,2*i+1);
			}
			if ( cnt == 0)
			{
				break;
			}
		
		}
		

		
		int limit = 0;
		while ( Arr.length - 1 - limit > 1){

			int temp = Arr[1];
			Arr[1] = Arr[Arr.length-1-limit];
			Arr[Arr.length-1-limit] = temp;
			Fix[Arr.length-1-limit] = true;
			/*for ( int i = 1 ;i <= N ; i++){
				
				System.out.print(Arr[i] + " ");
			}
			System.out.println("");*/
			for( int i = (int) (Math.pow(2,HeapLength)-1) ; i >= 1 ; i--)
			{
			MakeHeap(i,2*i,2*i+1);
			}
			
			limit ++;
			
		}
		
		
		for ( int i = 1 ;i <= N ; i++){
			
			System.out.print(Arr[i] + " ");
		}
	}
	
	public static void MakeHeap(int parent,int left,int right){
		int tmp;
		
		if ( Fix[right] == true && Fix[left] == false){
			if (Arr[left] > Arr[parent]){
				tmp = Arr[left];
				Arr[left] = Arr[parent];
				Arr[parent] = tmp;
				return;
			}
			return;
		}
		
		if ( Fix[right] == true && Fix[left] == true) { return; }

	    if ( Arr[left] >= Arr[right] ) {

		    if ( (Arr[parent] < Arr[left]) ) { 
		    	tmp = Arr[parent];
		    	Arr[parent] = Arr[left];
		    	Arr[left] = tmp;
		    	cnt ++ ;
		    	System.out.println("변경");
		    }
		}
	    else if( Arr[right] >= Arr[left] ){
	    	
		    if ( Arr[parent] < Arr[right] ) { 
		    	tmp = Arr[parent];
		    	Arr[parent] = Arr[right];
		    	Arr[right] = tmp;
		    	cnt ++;
		    	System.out.println("변경");
		    }
	    	
	    }

		
	}
	
}
