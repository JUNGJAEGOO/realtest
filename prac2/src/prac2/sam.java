package prac2;
import java.util.Scanner;

public class sam {

	public static void main (String[] args){
		Scanner input = new Scanner(System.in);
		int sootza[];
		int bin[][];
		int nam,mok,tmp;
		bin = new int[4][8];
		sootza = new int[4];
	
		for ( int i = 0 ; i<sootza.length ; i++){
			
		while(true){
			sootza[i] = input.nextInt();
			if (sootza[i]<=255 && sootza[i]>=0)
				break;
			else
				System.out.println("�Է������� ���� �ʽ��ϴ�. 0�̻� 256���� ���ڸ� �ٽ� �Է��ϼ���.");
		}
		}
		
		for ( int i = 0 ; i<sootza.length ; i++){
			tmp = sootza[i];
		for(int j = 7 ; j>-1;j--){
			nam = tmp%2;
			tmp = tmp/2;
			if (nam == 1){
				bin[i][j] = 1;
				
			}
			else{
				bin[i][j] = 0;
			}
			}
		}
		

	System.out.println("�Է� ���� ����  "+sootza[0]+" "+sootza[1]+" "+sootza[2]+" "+sootza[3]+" �Դϴ�.");
	System.out.print("2������ ǥ���ϸ� ");
	for(int i = 0 ; i<4 ; i++){
	for(int j = 0; j<8;j++){
	System.out.print(bin[i][j]);
	}
	System.out.print(" ");
	}
	System.out.println("�Դϴ�.");
	
	}

}
