// https://www.acmicpc.net/problem/1991
// 트리 순회
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Tree tree = new Tree();
		int N = Integer.parseInt(br.readLine());
		// 입력
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char a = st.nextToken().charAt(0);
			char b = st.nextToken().charAt(0);
			char c = st.nextToken().charAt(0);
			
			tree.Add(a, b, c);
		}
		
		tree.PreOrder(tree.root);
		System.out.println("");
		tree.InOrder(tree.root);
		System.out.println("");
		tree.PostOrder(tree.root);
		//br.close();
		System.exit(0);
	}
}
class Node{
	char val;
	Node left,right;

	public Node(char val) {
		this.val = val;
	}
}

class Tree{
	Node root;
	
	public void Add(char Data, char left_Data, char right_Data){
		if(root == null){
			if(Data!='.') root = new Node(Data);
			if(left_Data!='.') root.left = new Node(left_Data);
			if(right_Data!='.') root.right = new Node(right_Data);
		}else{
			Search(root, Data,left_Data,right_Data);
		}
	}
	
	public void Search(Node root, char Data, char left_Data, char right_Data){
		if(root==null){
			return;
		
		}else if(root.val==Data){
			if(left_Data!='.') root.left = new Node(left_Data);
			if(right_Data!='.') root.right = new Node(right_Data);
		
		}else{
			Search(root.left, Data,left_Data,right_Data);
			Search(root.right, Data,left_Data,right_Data);
		}
	}
	
	public void PreOrder(Node root){
		System.out.print(root.val);
		if(root.left!=null) PreOrder(root.left);
		if(root.right!=null) PreOrder(root.right);
	}
	public void InOrder(Node root){
		if(root.left!=null) InOrder(root.left);
		System.out.print(root.val);
		if(root.right!=null) InOrder(root.right);
	}
	public void PostOrder(Node root){
		if(root.left!=null) PostOrder(root.left);
		if(root.right!=null) PostOrder(root.right);
		System.out.print(root.val);
	}
	
	
}
