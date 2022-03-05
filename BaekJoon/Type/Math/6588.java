// https://www.acmicpc.net/problem/6588
// 골드바흐의 추측
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] pri = new boolean[1000001];
		pri[3]=true;
		pri[5]=true;
		for (int i = 7; i < 1000001; i+=2) {
			boolean ok = true;
			for (int j = 3; j*j <= i; j++) {
				if(i%j==0){
					ok = false;
					break;
				}
			}
			
			if(ok){
				pri[i]=true;
			}
		}
		
		while(true){
			int num = Integer.parseInt(br.readLine());
			if(num==0)
				break;
			
			for (int i = 3; i < 999998; i+=2) {
				if(pri[i] && pri[num-i]){
					sb.append(num+" = "+i+" + "+(num-i)+"\n");
					break;
				}
				
				if(i==999997)
					sb.append("Goldbach's conjecture is wrong.\n");
			}
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}
