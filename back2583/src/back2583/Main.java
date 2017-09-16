package back2583;

import java.util.*;

public class Main {


	static Scanner in = new Scanner(System.in);
	static int M = in.nextInt();
	static int N = in.nextInt();
	static int n = in.nextInt();
	static int leftX[] = new int[n];
	static int leftY[] = new int[n];
	static int rightX[] = new int[n];
	static int rightY[] = new int[n];
	static boolean visit[][] = new boolean[M+3][N+3];
	static int nulbi[] = new int[M*N];
	static int mat[][] = new int[M+3][N+3];
	static ArrayList<Integer> area= new ArrayList();
	static int count = 0;
	
	static void BFS(int x,int y){
		
		Queue<data> que= new LinkedList();
		
		que.offer(new data(x,y));
		visit[x][y]=true;
		count++;
		
		while(!que.isEmpty()){
			
			data XY = que.poll();
			
			if(mat[XY.i+1][XY.j] == 1 && visit[XY.i+1][XY.j]==false){
				que.offer(new data(XY.i+1,XY.j));
				visit[XY.i+1][XY.j]=true;
				count++;
			}
			if(mat[XY.i][XY.j+1] == 1 && visit[XY.i][XY.j+1]==false){
				que.offer(new data(XY.i,XY.j+1));
				visit[XY.i][XY.j+1]=true;
				count++;
			}
			if(mat[XY.i-1][XY.j] == 1 && visit[XY.i-1][XY.j]==false){
				que.offer(new data(XY.i-1,XY.j));
				visit[XY.i-1][XY.j]=true;
				count++;
			}
			if(mat[XY.i][XY.j-1] == 1 && visit[XY.i][XY.j-1]==false){
				que.offer(new data(XY.i,XY.j-1));
				visit[XY.i][XY.j-1]=true;
				count++;
			}
			
		}
		
	}
	
	static class data{
		int i,j;
		data(int i,int j){
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String args[]){
		
		
		for(int i=1;i<M+1;i++){
			for(int j=1;j<N+1;j++){
				mat[i][j] = 1;
				visit[i][j] = false;
			}
		}
		
		for(int i=0;i<n;i++){
			leftX[i] = in.nextInt();
			leftY[i] = in.nextInt();
			rightX[i] = in.nextInt();
			rightY[i] = in.nextInt();
		}
		
		for(int z=0;z<n;z++){
		for(int i=leftY[z]+1;i<rightY[z]+1;i++){
			for(int j=leftX[z]+1;j<rightX[z]+1;j++){
				mat[i][j] = 0;
				visit[i][j]= true;
			}
		}
		}
		
		for(int i=1;i<=M+1;i++){
			for(int j=1;j<=N+1;j++){
				if(visit[i][j]==false && mat[i][j] == 1){
					BFS(i,j);
					area.add(count);
					count = 0;
				}
				

			}
		}

		System.out.println("°¹¼ö "+area.size());
		Collections.sort(area);
		for(int i=0;i<area.size();i++){;
		System.out.println(area.get(i));
		}
		
		for(int i=1;i<=M;i++){
			for(int j=1;j<=N;j++){

				System.out.print(mat[i][j]);
			}
			System.out.println();
		}

	}
	
}
