package wordtrans;

import java.util.Scanner;
public class word {

	
	public static void main(String args[]){
	
		
		Scanner in = new Scanner(System.in);
		
		int money = in.nextInt();
		int[] data = new int[1000];
		int nam;
		int count = 0;
		while(money>10000){
			
			nam = money % 10000;
			money = money / 10000;
			data[count] = nam;
			count++;
	
	
		}
	
		for(int i=count;i>=0;i--){
			int cheon;
			int bak;
			int sib;
			int ill;
			char ch=' ';
			char ba=' ';
			char si=' ';
			char il=' ';
		
			cheon = data[i]/1000;
			bak = (data[i]-cheon)/100;
			sib = (data[i]-cheon-bak)/10;
			ill = data[i]-cheon-bak-sib;
			
			switch(cheon){
			case 0:
			ch = ' ';
				break;
			case 1:
			ch = '��';
			break;
			case 2:
			ch = '��';
			break;
			case 3:
			ch = '��';
			break;
			case 4:
			ch = '��';
			break;
			case 5:
			ch = '��';
			break;
			case 6:
			ch = '��';
			break;
			case 7:
			ch = 'ĥ';
			break;
			case 8:
			ch = '��';
			break;
			case 9:
			ch = '��';
			break;
			}
			switch(bak){
			case 0:
			ch = ' ';
			break;
			case 1:
			ba = '��';
			break;
			case 2:
			ba = '��';
			break;
			case 3:
			ba = '��';
			break;
			case 4:
		    ba = '��';
			break;
			case 5:
			ba = '��';
			break;
			case 6:
			ba = '��';
			break;
			case 7:
			ba = 'ĥ';
			break;
			case 8:
			ba = '��';
			break;
			case 9:
			ba = '��';
			break;
			}
			switch(sib){
			case 0:
			si = ' ';
			break;
			case 1:
			si = '��';
			break;
			case 2:
			si = '��';
			break;
			case 3:
			si = '��';
			break;
			case 4:
			si = '��';
			break;
			case 5:
			si = '��';
			break;
			case 6:
			si = '��';
			break;
			case 7:
			si = 'ĥ';
			break;
			case 8:
			si = '��';
			break;
			case 9:
			si = '��';
			break;
			}
			switch(ill){
			case 0:
			il = ' ';
			break;
			case 1:
			il = '��';
			break;
			case 2:
			il = '��';
			break;
			case 3:
			il = '��';
			break;
			case 4:
			il = '��';
			break;
			case 5:
			il = '��';
			break;
			case 6:
			il = '��';
			break;
			case 7:
			il = 'ĥ';
			break;
			case 8:
			il = '��';
			break;
			case 9:
			il = '��';
			break;
			}
			
			char danwi=' ';
			System.out.print(ch+'õ'+ba+'��'+si+'��'+il);
			switch(i){
			case 4:
				danwi = '��';
				break;
			case 3:
				danwi = '��';
				break;
			case 2:
				danwi = '��';
				break;
			case 1:
				danwi = '��';
				break;
			case 0:
				danwi = ' ';
				break;
			
			}
			System.out.print(danwi);
		}
	
	}
	
}
