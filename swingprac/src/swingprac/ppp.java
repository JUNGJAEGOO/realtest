package swingprac;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ppp extends JFrame {
	JPanel content = new JPanel();
	JLabel a;
	
	ppp(){
		setTitle("상 하 좌 우 키를 이용해보세요.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content.setLayout(null);
		setContentPane(content);
		a = new JLabel("Love Java");
		a.setFont(new Font("Arial",Font.PLAIN,10));
		a.setLocation(50, 50);
		a.setSize(300,300);
		
		myaction listen = new myaction();
		content.add(a);
		content.addMouseWheelListener(listen);
		
		setVisible(true);
		setSize(300,300);
		//content.requestFocus();
	}
	
	class myaction implements MouseWheelListener{
		public void mouseWheelMoved(MouseWheelEvent e){
			int s = e.getWheelRotation();
			Font f = a.getFont();
			int size = f.getSize();
			
			if(s > 0){
				a.setFont(new Font("Arial",Font.PLAIN,size+5));
			}
			else if(s <0){
				a.setFont(new Font("Arial",Font.PLAIN,size-5));
			}

			
		}

	}
	
	public static void main(String args[]){
		
		new ppp();
	}
	

}
