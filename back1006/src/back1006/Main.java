package back1006;
import java.util.*;
public class Main {

	static Scanner in = new Scanner(System.in);
	static int topdata[][];
	static int botdata[][];

	
	public static void main(String args[]){
		
		int T = in.nextInt();
		int tcase = 0;
		int ans[] = new int[T];
		
		while ( T > tcase ){
		int N = in.nextInt();
		int W = in.nextInt();
		topdata = new int[N][5];
		botdata = new int[N][5];    // 0 비용 1 자신 2 좌 3 우 4 상or하
		for( int i = 0 ; i < N ; i ++ ){
			botdata[i][1] = i+1;
			botdata[i][0] = in.nextInt();
			
		}
		for( int i = 0 ; i < N ; i ++ ){
			topdata[i][1] = N+i+1;
			topdata[i][0] = in.nextInt();
			
		}
	
	
		for( int i = 0 ; i< N ; i ++ ){
			botdata[i][3] = botdata[(i+1)%N][1];
			botdata[i][2] = botdata[(N+i-1)%N][1];
			botdata[i][4] = topdata[i][1];
			
			topdata[i][3] = topdata[(i+1)%N][1];
			topdata[i][2] = topdata[(N+i-1)%N][1];
			topdata[i][4] = botdata[i][1];

		}
		
/*		for( int i = 0 ; i < N ; i ++ ){
			System.out.println("비용: "+topdata[i][0]+" 자신: "+topdata[i][1]+" 봇: "+topdata[i][4] +" 좌: "+topdata[i][2]+" 우: "+topdata[i][3]);
		
		
		}
		for( int i = 0 ; i < N ; i ++ ){
			
			System.out.println("비용: "+botdata[i][0]+" 자신: "+botdata[i][1]+" 탑: "+botdata[i][4] +" 좌: "+botdata[i][2]+" 우: "+botdata[i][3]);
		
		}*/

		int count = 0;
		for( int i = 0 ; i < N ; i ++ ){
			if ( botdata[i][0] != 0  && botdata[i][0] <= W ){ 
				
				int dist = W - botdata[i][0];
				botdata[i][0] = 0;
				count++;
				int max = -1;
				int select = -1;
				if(topdata[i][0] != 0 && topdata[i][0] <= dist){
					if (topdata[i][0] + botdata[i][0] > max){ max = topdata[i][0]+botdata[i][0]; select=1;}
				}
				if ( botdata[(N+i-1)%N][0] != 0 && botdata[(N+i-1)%N][0] <= dist){
					if (botdata[i][0] + botdata[(N+i-1)%N][0] > max){ max = botdata[i][0]+botdata[(N+i-1)%N][0]; select=2;}
				}
				if ( botdata[(N+i+1)%N][0] != 0 && botdata[(N+i+1)%N][0] <= dist){
					if (botdata[i][0] + botdata[(N+i+1)%N][0] > max){ max = botdata[i][0]+botdata[(N+i+1)%N][0]; select=3;}
				}
				//System.out.println(botdata[i][1]+"추적"+select);
				
				if ( select == 1){
					topdata[i][0] = 0;
				}
				else if ( select == 2){
					botdata[ (N+i-1)%N ][0] = 0;
				}
				else if ( select == 3 ){
					botdata[ (N+i+1)%N ][0] = 0;
				}
				
			}

		}
		
		for( int i = 0 ; i < N ; i ++ ){
			if ( topdata[i][0] != 0  && topdata[i][0] <= W ){ 
				
				int dist = W - topdata[i][0];
				topdata[i][0] = 0;
				count++;
				int max = -1;
				int select = -1;
				if(botdata[i][0] != 0 && botdata[i][0] <= dist){
					if (topdata[i][0] + botdata[i][0] > max){ max = topdata[i][0]+botdata[i][0]; select=1;}
					 
				}
				if ( topdata[(N+i-1)%N][0] != 0 && topdata[(N+i-1)%N][0] <= dist){
					if (topdata[i][0] + topdata[(N+i-1)%N][0] > max){ max = topdata[i][0]+topdata[(N+i-1)%N][0]; select=2;}
					
				}
				if ( topdata[(N+i+1)%N][0] != 0 && topdata[(N+i+1)%N][0] <= dist){
					if (topdata[i][0] + topdata[(N+i+1)%N][0] > max){ max = topdata[i][0]+topdata[(N+i+1)%N][0]; select=3;}
				}
				//System.out.println(topdata[i][1]+"추적"+select);
				
				if ( select == 1){
					botdata[i][0] = 0;
				}
				else if ( select == 2){
					topdata[ (N+i-1)%N ][0] = 0;
				}
				else if ( select == 3 ){
					topdata[ (N+i+1)%N ][0] = 0;
				}
				
			}

		}
		
/*		for( int i = 0 ; i < N ; i ++ ){
			System.out.println("비용: "+topdata[i][0]+" 자신: "+topdata[i][1]+" 봇: "+topdata[i][4] +" 좌: "+topdata[i][2]+" 우: "+topdata[i][3]);
		
		
		}
		for( int i = 0 ; i < N ; i ++ ){
			
			System.out.println("비용: "+botdata[i][0]+" 자신: "+botdata[i][1]+" 탑: "+botdata[i][4] +" 좌: "+botdata[i][2]+" 우: "+botdata[i][3]);
		
		}*/
		ans[tcase] = count;
		tcase++;
		
		
		}
		for(int i=0;i<tcase;i++){
		System.out.println(ans[i]);
		}
		
	}
	

}
