import java.util.*;
import java.io.*;
public class Main {
	static Node root;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Tree t = new Tree();
		
		for ( int i = 0 ; i< N ; i++){
			String tmp = br.readLine();
			st = new StringTokenizer(tmp," ");
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			t.add(data,left,right);
		}
		
		t.preorder(root);
		System.out.println();
		t.inorder(root);
		System.out.println();
		t.backorder(root);
		System.out.println();
	}
	
	public static class Tree{
	
		public static void add(char data,char left,char right){
			if ( root == null ){
				root = new Node(data);
				if ( left != '.'){ root.left = new Node(left);}
				if ( right != '.'){ root.right = new Node(right);}
			}else{
				search(root,data,left,right);
			}
		}
		
		public static void search(Node root,char data,char left,char right){

			if( root == null){ return; }
			else if ( data == root.data){
				if ( left!='.') {root.left = new Node(left);}
				if ( right!='.'){root.right = new Node(right);}
			}
			else{
				search(root.left,data,left,right);
				search(root.right,data,left,right);
			}
			return;
		}
		
		public static void preorder(Node root){
			System.out.print(root.data);
			if ( root.left !=null) preorder(root.left);
			if ( root.right != null) preorder(root.right);
		}
		
		public static void inorder(Node root){
			if ( root.left !=null) inorder(root.left);
			System.out.print(root.data);
			if ( root.right != null) inorder(root.right);
		}
		public static void backorder(Node root){
			
			if( root.left!=null){backorder(root.left);}
			if( root.right!=null){backorder(root.right);}
			System.out.print(root.data);
		}
	}
	
	
	public static class Node{
		char data;
		Node left;
		Node right;
		Node(char data){
			this.data = data;
		}
	}
}
