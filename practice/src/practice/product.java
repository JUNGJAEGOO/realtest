package practice;
import java.util.Scanner;

public class product {
	
	String sort;
	String explain;
	String maker;
	String price;
	
	

public static void main(String args[]){
	int num = 0;
	Book a[] = new Book[10];
	CD b[] = new CD[10];
	int Bnum = -1;
	int Cnum = -1;
	
	while(true){
	Scanner input = new Scanner(System.in);
	

	System.out.println("���� ��ϵ� ��ǰ ���� : "+num+"�� ");
	System.out.print("��ǰ�߰�<1>, ��� ��ǰ ��ȸ<2>, ������<3> : ");
	int in;
	int in2;
	String in3;

	in = input.nextInt();

	
	{if (in == 1){
		if (num==10){ System.out.println("���̻� �Է��� �� �����ϴ�. ó������ ���� ���ϴ�."); continue;}
		System.out.print("��ǰ���� å<1> ����<2> : ");
		in2 = input.nextInt();
		input.nextLine();
		if (in2 == 1){
			Bnum=Bnum+1;
			a[Bnum] = new Book();
			System.out.print("��ǰ ����  >> ");
			in3 = input.nextLine();
			a[Bnum].explain = in3;
			System.out.print("������  >> ");
			in3 = input.nextLine();
			a[Bnum].maker = in3;
			System.out.print("����  >> ");
			in3 = input.nextLine();
			a[Bnum].price = in3;
			System.out.print("ý  ����  >> ");
			in3 = input.nextLine();
			a[Bnum].Btitle = in3;
			System.out.print("����  >> ");
			in3 = input.nextLine();
			a[Bnum].writer = in3;
			System.out.print("���  >> ");
			in3 = input.nextLine();
			a[Bnum].lang = in3;
			System.out.print("ISBN  >> ");
			in3 = input.nextLine();
			a[Bnum].ISBN = in3;
			num = num + 1;

			
		}
		else if(in2 ==2){
			Cnum=Cnum+1;
			b[Cnum] = new CD();
			System.out.print("��ǰ ����  >> ");
			in3 = input.nextLine();
			b[Cnum].explain = in3;
			System.out.print("������  >> ");
			in3 = input.nextLine();
			b[Cnum].maker = in3;
			System.out.print("����  >> ");
			in3 = input.nextLine();
			b[Cnum].price = in3;
			System.out.print("�ٹ�  ����  >> ");
			in3 = input.nextLine();
			b[Cnum].Ctitle = in3;
			System.out.print("����  >> ");
			in3 = input.nextLine();
			b[Cnum].singer = in3;
			//System.out.println(b[0].maker);
			num = num + 1;
		}

	}
	else if(in == 2){
		if(num==0){ System.out.println("�켱 ��ǰ�� �ϳ��� �߰��ϰ� �� �ɼ��� ���Ͻʽÿ�. "); continue;}
		int i = 0;
		int j = 0;
		
		while(a[i]!=null){
	    System.out.println("------------------------------");
		System.out.println("��ǰ ����  : "+a[i].explain);
		System.out.println("������  : "+a[i].maker);
		System.out.println("����  : "+a[i].price);
		System.out.println("å���� : "+a[i].Btitle);
		System.out.println("���� : "+a[i].writer);
		System.out.println("���  :"+a[i].lang);
		System.out.println("ISBN : "+a[i].ISBN);
		System.out.println("------------------------------");
		i = i+ 1;
		}
		while(b[j]!=null){
			System.out.println("------------------------------");
			System.out.println("��ǰ ����  : "+b[j].explain);
			System.out.println("������  : "+b[j].maker);
			System.out.println("����  : "+b[j].price);
			System.out.println("�ٹ� ����  : "+b[j].Ctitle);
			System.out.println("����  : "+b[j].singer);
			System.out.println("------------------------------");
			j = j + 1;
		}
	}
	else if(in == 3){
		break;
		}
	}
	}
}

}