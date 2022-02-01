// https://www.acmicpc.net/problem/4673
// 셀프 넘버
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		Set<Integer> s = new HashSet<>();	
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i< 10001; i++){
			int next = i;
			int addNum = i;
			while(next>0){
				addNum+=next%10;
				next/=10;
			}
			s.add(addNum);
		}
		
		for (int i = 1; i < 10001; i++) {
			if(!s.contains(i))sb.append(i+"\n");
		}
		System.out.println(sb);
		//br.close();
		System.exit(0);
	}
}
