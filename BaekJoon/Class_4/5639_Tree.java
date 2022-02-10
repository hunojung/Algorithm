// https://www.acmicpc.net/problem/5639
// 이진 검색 트리
import java.io.*;
import java.util.*;


public class Main {
	static StringBuilder sb;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		// 입력
		String s;
		Node head = new Node(Integer.parseInt(br.readLine()));
		while(true){
			s = br.readLine();
			if(s == null || s.equals(""))
				break;
			head.insert(Integer.parseInt(s));
		}
		
		postOrder(head);
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	static class Node{
		int val;
		Node left,right;
		Node(int val){
			this.val=val;
		}
		
		void insert(int n){
			if(n<val){
				if(left==null)
					left = new Node(n);
				else
					this.left.insert(n);
			}else{
				if(right==null)
					right = new Node(n);
				else
					this.right.insert(n);
			}
		}
	}
		
	static void postOrder(Node root){
		if(root==null)return;
		
		postOrder(root.left);
		postOrder(root.right);
		sb.append(root.val+"\n");
	}
}
