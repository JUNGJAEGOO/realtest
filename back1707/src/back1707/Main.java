package back1707;
import java.util.*;
public class Main {
	static ArrayList<data> adj[];
	static ArrayList<data> node;
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while ( T > 0){
			
			int V = in.nextInt();
			int E = in.nextInt();
			
			adj = new ArrayList[V];
			node = new ArrayList<data>();
			for ( int i = 0 ; i < V ; i++){
				adj[i] = new ArrayList<data>();
				node.add(new data(i));
			}
			for ( int i = 0 ; i < E ; i++){
				int x = in.nextInt()-1;
				int y = in.nextInt()-1;
				adj[x].add(new data(y));
				adj[y].add(new data(x));
			}
			
			
			
			boolean result = DFS(0);
			System.out.println(result);
			T--;
		}
	}
	
	public static boolean DFS(int start){
		
		Stack<Integer> st = new Stack<Integer>();
		st.push(start);
		node.get(start).color = 0;
		while ( !st.isEmpty() ){
			int tmp = st.pop();
			
			for ( int i = 0 ; i < adj[tmp].size() ; i++ ){
				if ( adj[tmp].get(i).color == -1 ){
					st.push(adj[tmp].get(i).num);
						if( node.get(tmp).color == 1){
							System.out.println(node.get(tmp).num+"의 색은"+node.get(tmp).color
									+"이고 "+adj[tmp].get(i).num+"의 색을 0으로 바꾼다");
							adj[tmp].get(i).color = 0;
							node.get(adj[tmp].get(i).num).color =0;
						}else{
							System.out.println(node.get(tmp).num+"의 색은"+node.get(tmp).color
									+"이고 "+adj[tmp].get(i).num+"의 색을 1으로 바꾼다");
							adj[tmp].get(i).color = 1;
							node.get(adj[tmp].get(i).num).color =1;
						}
				}
				else if ( adj[tmp].get(i).color == node.get(tmp).color ){
					System.out.println(adj[tmp].get(i).num +" "+ node.get(tmp).num);
					return false;
				}
			}
		}
		
		return true;
	};
	
	public static class data{
		int color = -1;
		int num;
		data(int num){
			this.num = num;
		}
	}
}
