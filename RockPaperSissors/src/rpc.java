import java.util.Scanner;

public class rpc {

	public static void main (String args[]){
		

		Scanner scan = new Scanner(System.in);
		String input;
		
		System.out.println("����,����,�� �� �ϳ��� �Է� �Ͻÿ�.");

		int num = 3;
		
		while(true)
		{
			
		input = scan.nextLine();
			
		if(input.equals("����")){
			num = 0;
			break;
		}
		else if(input.equals("����")){
			num = 1;
			break;
		}
		else if(input.equals("��")){
			num = 2;
			break;
		}
		else {
			System.out.println("����� �ٽ� �Է� ���ּ���.");
		}
		
	    }
		
		int com;
		String trancom;
		com = (int)(Math.random()*3);
		
		if(com == 0)
		{
			trancom = "����";
		}
		else if(com == 1)
		{
			trancom = "����";
		}
		else
		{ trancom = "��";}
		
		System.out.println("��ǻŸ�� ������ "+ trancom);
		if(num == com){
			System.out.println("�����ϴ�");
		}
		else if(num == 0 && com == 1){
			System.out.println("�����ϴ�");
		}
		else if(num == 0 && com == 2){
			System.out.println("�̰���ϴ�");
		}
		else if(num == 1 && com == 0){
			System.out.println("�̰���ϴ�");
		}
		else if(num == 1 && com == 2){
			System.out.println("�����ϴ�");
		}
		else if(num == 2 && com == 0){
			System.out.println("�����ϴ�");
		}
		else if(num == 2 && com == 1){
			System.out.println("�̰���ϴ�");
		}
		
}
}
