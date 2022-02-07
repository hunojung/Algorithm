// https://www.acmicpc.net/problem/2263
// 트리의 순회
package algorithm;

import java.io.*;
import java.util.*;

public class Main {
	static int[] inOrder,postOrder,index;
	static StringBuilder sb;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		// 입력
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		inOrder = new int[N];
		postOrder = new int[N];
		index = new int[N+1];
		for (int i = 0; i < N; i++) {
			inOrder[i]=Integer.parseInt(st1.nextToken());
			postOrder[i]=Integer.parseInt(st2.nextToken());
		}
		
		// inOrder에서 특정 값의 인덱스 바로 찾기
		for (int i = 0; i < N; i++) {
			index[inOrder[i]]=i;
		}
		
		getPreOrder(0,N-1,0,N-1);
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd){
		if(inStart>inEnd || postStart>postEnd) return;
		
		sb.append(postOrder[postEnd]+" ");
		
		// 방금 입력한 루트 기준 왼쪽 인덱스 찾아야하니까 inOrder에서 
		int position = index[postOrder[postEnd]];
		//왼쪽 자식 갯수
		int left = position-inStart;
		// 왼쪽 자식 트리를이용해 반복
		getPreOrder(inStart,position-1,postStart,postStart+left-1);
		// 오른쪽 자식 트리를 이용해 반복
		getPreOrder(position+1,inEnd,postStart+left,postEnd-1);
		
	}
}
