package back1049;
import java.util.*;
public class Main {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int lost = in.nextInt();
		int M = in.nextInt();
		int pack[][] = new int[M][2];
		int min[] = new int[2];
		min[0] = 10000;  // ��ǰ ������ �ּ�
		min[1] = 10000;  // ��Ű�� ������ �ּ�
		for(int i = 0 ; i < M ; i++){
			pack[i][1] = in.nextInt();
			pack[i][0] = in.nextInt();
			
			if ( min[1] > pack[i][1]){
				min[1] = pack[i][1];
			}
			if ( min[0] > pack[i][0]){
				min[0] = pack[i][0];
			}
		}
		
		int result = 0;
		if ( lost <= 6){
			if ( min[0]*lost >= min[1]){
				result = min[1];
			}
			else if ( min[0]*lost < min[1]){
				while ( lost > 0){
					lost -= 1;
					result+=min[0];
					//System.out.println("���ϱ�");
				}
			}
		}
		else if( lost > 6){
			if ( min[0]*6 >= min[1]){
				while ( lost > 6){
					lost -= 6;
					result += min[1];
					//System.out.println("�� ���ϱ�");
				}
				if( lost > 0 && lost < 6 ){
					if ( min[0]*lost >= min[1]){
						result += min[1];
						//System.out.println("���ϱ�");
					}
					else if ( min[0]*lost < min[1]){
						while ( lost > 0){
							lost -= 1;
							result+=min[0];
							//System.out.println("���ϱ�");
						}
					}
				}
				else if ( lost == 6){
					lost -= 6;
					result += min[1];
				}
			}
			else if( min[0]*6 < min[1]){
				while ( lost > 0){
					lost -= 1;
					result+=min[0];
					//System.out.println("���ϱ�");
				}
			}
		}
		
		System.out.println(result);
		
	}
}
