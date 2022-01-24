// https://www.acmicpc.net/problem/3649
// 로봇 프로젝트

// 이분 탐색 보다는
// 맵, 두 포인터로 풀이

// 분류
// 정렬
// 이분 탐색
// 두 포인터

// 두 포인터 풀이
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		String s;
		while(( s = br.readLine() )!= null && !s.isEmpty() ){
			int x = Integer.parseInt(s)*10000000 ;
			int N = Integer.parseInt(br.readLine());
			int[] rego = new int[N];
			for (int i = 0; i < N; i++) {
				rego[i]=Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(rego);
			
			int start = 0;
			int end = N-1;
			int a = 0;
			int b = 0;
			boolean ok = false;
			while(start<end){
				
				int sum = rego[start]+rego[end];
				if(sum==x){
					a = rego[start];
					b = rego[end];
					ok = true;
					break;
				}
				
				if(sum<x){
					start++;
				}else{
					end--;
				}
			}
			
			if(ok){
				System.out.println("yes "+a+" "+b);
			}else{
				System.out.println("danger");
			}
		}
		
		
		br.close();
		System.exit(0);
	}
}

// HashMap 풀이
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		String s = "";
		while(( s = br.readLine() )!= null && !s.isEmpty() ){
			int x = Integer.parseInt(s)*10000000 ;
			int N = Integer.parseInt(br.readLine());
			int[] rego = new int[N];
			HashMap<Integer,Integer> hm = new HashMap<>();
			for (int i = 0; i < N; i++) {
				rego[i]=Integer.parseInt(br.readLine());
				hm.put(rego[i],hm.getOrDefault(rego[i], 0)+1);
			}
			Arrays.sort(rego);
			int l1 = 0;
			int l2 = 0;
			boolean ok = false;
			
			for (int i=0;i<N;i++) {
				int next = rego[i];
				
				if(hm.containsKey(x-next)){
					if(next==(x-next)){
						if(hm.get(next)>1){
							l1 = next;
							l2 = x-l1;
						}else{
							continue;
						}
					}else{
						l1 = next;
						l2 = x-l1;
					}
					ok = true;
					break;
				}
			}
			
			if(ok){
				System.out.println("yes "+l1+" "+l2);
			}else{
				System.out.println("danger");
			}
		}
		
		
		br.close();
		System.exit(0);
	}
}
