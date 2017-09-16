
public class Main {

	static int arr[] = { 9 , 15 , 41 , 7 , 3 , 2 , 10 , 20, 33 , 100 ,23,34 ,41};
	
	public static void main(String args[]){
		
		
		
		quicksort(arr,0,arr.length-1);
		
		for(int i=0;i<arr.length;i++){
		System.out.print(arr[i]+ " ");
		}
	}
	
	
	public static void quicksort(int arr[],int left,int right){
		
		int key = arr[left];
		int i = left;
		int j = right;
        i++;
		if(left<right){
		while ( i < j){
			
			while (  arr[i] < key && i < right ){
				i ++ ;
			}
			
			while (  arr[j] > key && j > left){
				j --;
			}
			if(i < j){
			int tmp = arr[i];
			arr[i] = arr[j];
			System.out.print(arr[j]+ "와  ");
			arr[j] = tmp;
			System.out.println(tmp + " 교환" );
			}

		}
		
		if(arr[j] < arr[left]){
		int temp = arr[j];
		System.out.print(arr[left]+ "와  ");
		arr[j] = arr[left];
		arr[left] = temp;
		System.out.println(temp + " 교환" );
		}
		if(left<j){
		quicksort(arr,left,j-1);}
		if(right>i){
		quicksort(arr,j+1,right);
		}
		
	}
	
	}
}
