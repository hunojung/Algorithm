// https://www.acmicpc.net/problem/7662
// 이중 우선순위 큐

// 분류
// 자료 구조
// 트리를 사용한 집합과 맵
// 우선순위 큐
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(testcase-->0){
			TreeMap<Integer,Integer> ts = new TreeMap<>();
			
			int N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				
				if(s.equals("I")){
					ts.put(number, ts.getOrDefault(number, 0)+1);
				}else{
					if(ts.isEmpty())continue;
					
					if(number == 1){
						number = ts.lastKey();
					}else{
						number = ts.firstKey();
					}
					
					if(ts.get(number)==1){
						ts.remove(number);
					}else{
						ts.put(number, ts.get(number)-1);								
					}
					
				}
			}
			if(ts.isEmpty()){
				sb.append("EMPTY").append("\n");
			}
			else{
				sb.append(ts.lastKey()+" "+ts.firstKey()).append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}
