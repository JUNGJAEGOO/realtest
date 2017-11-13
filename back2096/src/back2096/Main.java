package back2096;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxLdp[] = new int[N];
		int maxMdp[] = new int[N];
		int maxRdp[] = new int[N];
		int minLdp[] = new int[N];
		int minMdp[] = new int[N];
		int minRdp[] = new int[N];
		int L[] = new int[N];
		int M[] = new int[N];
		int R[] = new int[N];
		StringTokenizer st;
		for ( int i = 0 ; i < N ; i++){
			String tmp = br.readLine();
			st = new StringTokenizer(tmp," ");
			L[i] = Integer.parseInt(st.nextToken());
			M[i] = Integer.parseInt(st.nextToken());
			R[i] = Integer.parseInt(st.nextToken());
		}
		maxLdp[0] = L[0];
		maxMdp[0] = M[0];
		maxRdp[0] = R[0];
		minLdp[0] = L[0];
		minMdp[0] = M[0];
		minRdp[0] = R[0];
		for ( int i = 1 ; i < N ; i++){
			maxLdp[i] = L[i]+ Math.max(maxLdp[i-1],maxMdp[i-1]);
			maxMdp[i] = M[i]+ Math.max(maxLdp[i-1],Math.max(maxMdp[i-1],maxRdp[i-1]));
			maxRdp[i] = R[i]+ Math.max(maxRdp[i-1],maxMdp[i-1]);
			
			minLdp[i] = L[i]+ Math.min(minLdp[i-1],minMdp[i-1]);
			minMdp[i] = M[i]+ Math.min(minLdp[i-1],Math.min(minMdp[i-1],minRdp[i-1]));
			minRdp[i] = R[i]+ Math.min(minRdp[i-1],minMdp[i-1]);
		}
		int max = Math.max(maxLdp[N-1],Math.max(maxMdp[N-1],maxRdp[N-1]));
		int min = Math.min(minLdp[N-1],Math.min(minMdp[N-1],minRdp[N-1]));
		System.out.println(max+" "+min);
		
	}
}
