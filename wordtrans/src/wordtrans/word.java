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
			ch = 'ÀÏ';
			break;
			case 2:
			ch = 'ÀÌ';
			break;
			case 3:
			ch = '»ï';
			break;
			case 4:
			ch = '»ç';
			break;
			case 5:
			ch = '¿À';
			break;
			case 6:
			ch = 'À°';
			break;
			case 7:
			ch = 'Ä¥';
			break;
			case 8:
			ch = 'ÆÈ';
			break;
			case 9:
			ch = '±¸';
			break;
			}
			switch(bak){
			case 0:
			ch = ' ';
			break;
			case 1:
			ba = 'ÀÏ';
			break;
			case 2:
			ba = 'ÀÌ';
			break;
			case 3:
			ba = '»ï';
			break;
			case 4:
		    ba = '»ç';
			break;
			case 5:
			ba = '¿À';
			break;
			case 6:
			ba = 'À°';
			break;
			case 7:
			ba = 'Ä¥';
			break;
			case 8:
			ba = 'ÆÈ';
			break;
			case 9:
			ba = '±¸';
			break;
			}
			switch(sib){
			case 0:
			si = ' ';
			break;
			case 1:
			si = 'ÀÏ';
			break;
			case 2:
			si = 'ÀÌ';
			break;
			case 3:
			si = '»ï';
			break;
			case 4:
			si = '»ç';
			break;
			case 5:
			si = '¿À';
			break;
			case 6:
			si = 'À°';
			break;
			case 7:
			si = 'Ä¥';
			break;
			case 8:
			si = 'ÆÈ';
			break;
			case 9:
			si = '±¸';
			break;
			}
			switch(ill){
			case 0:
			il = ' ';
			break;
			case 1:
			il = 'ÀÏ';
			break;
			case 2:
			il = 'ÀÌ';
			break;
			case 3:
			il = '»ï';
			break;
			case 4:
			il = '»ç';
			break;
			case 5:
			il = '¿À';
			break;
			case 6:
			il = 'À°';
			break;
			case 7:
			il = 'Ä¥';
			break;
			case 8:
			il = 'ÆÈ';
			break;
			case 9:
			il = '±¸';
			break;
			}
			
			char danwi=' ';
			System.out.print(ch+'Ãµ'+ba+'¹é'+si+'½Ê'+il);
			switch(i){
			case 4:
				danwi = '°æ';
				break;
			case 3:
				danwi = 'Á¶';
				break;
			case 2:
				danwi = '¾ï';
				break;
			case 1:
				danwi = '¸¸';
				break;
			case 0:
				danwi = ' ';
				break;
			
			}
			System.out.print(danwi);
		}
	
	}
	
}
