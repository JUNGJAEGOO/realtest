package back1021;
import java.util.*;
public class Main {

	public static void main(String args[]){
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int find[] = new int[M];
		for(int i = 0 ; i < M ; i++){
			find[i] = in.nextInt();
		
		}
		
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for( int i = 0 ; i < N ; i++){
			
			dq.addLast(i+1);
			
		}
		
		int sum = 0;
		int count = 0;
		while ( true ){
			
		
			System.out.println("dd"+find[count]);
		if(find[count] == (int)dq.peekFirst() ){
			
			//System.out.println("삭제"+find[count]);
			count++;
			dq.removeFirst();
		}
		else {
			int index = FindIndex(dq,find[count]);
			System.out.println("인덱스"+index);
			count++;
		    sum += index;
		}
		
		int size = dq.size();
		
		Deque<Integer> tempque = new LinkedList<Integer>();
		int tmparr[] = new int[size];
		for ( int i = 0 ; i<size ; i++){
			tmparr[i] = dq.removeFirst();
			tempque.addLast(tmparr[i]);
			dq.addLast(tmparr[i]);
		}
		
		for(int i = 0; i<size;i++){
			System.out.println(tempque.removeFirst());
		}
		
		if(count >= find.length){
			break;
		}
		
		}
		
		
		
		
		
			System.out.println(sum);
		
		
	}
	
	public static int FindIndex(Deque<Integer> dq,int x){
		Deque<Integer> copy1 = new LinkedList<Integer>();
		Deque<Integer> copy2 = new LinkedList<Integer>();
		
		int size = dq.size();
		int tmparr[] = new int[size];
		
		for ( int i = 0 ; i<size ; i++){
			tmparr[i] = dq.removeFirst();
			copy1.addLast(tmparr[i]);
			copy2.addLast(tmparr[i]);
	
			dq.addLast(tmparr[i]);
		}
		
		
		
		int left = -1;
		int right = -1;
		
		
		for(int i = 0; i <size; i++){
			
			if ( x == (int)copy1.removeFirst() ){
				left = i;
			}
			
		}
		
		for(int i = 0; i <size; i++){
			
			if ( x == (int)copy2.removeLast() ){
				right = i+1;
			}
			
		}
		
		System.out.println("left:"+left+"right"+right);
		
		if ( left >= right ){
			//System.out.println("왼쪽길이가 더 깁니다.");
			int tmp = dq.size() - left;
			System.out.println("삭제를 원하는"+tmp);
			while ( tmp > 0){
				int temp = (int) dq.removeLast();
				
				dq.addFirst(temp);
				tmp--;
			}
			dq.removeLast();
		return right;
		}
		else {
			//System.out.println("오른쪽길이가 더 깁니다." );
			int tmp = left;
			while ( tmp > 0){
				int temp = (int) dq.removeFirst();
				dq.addLast(temp);
				tmp--;
			}
			dq.removeFirst();
		return left;
		}
		
		
	}
}
