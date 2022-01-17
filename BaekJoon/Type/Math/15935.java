// 상금 헌터
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] k2017 = new int[21];
		int[] k2017_money = {500,300,200,50,30,10};
		int count = 1;
		int people = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < count; j++) {
				k2017[people]=k2017_money[i];
				people++;
			}
			count+=1;
		}
		
		int[] k2018 = new int[31];
		int[] k2018_money = {512,256,128,64,32};
		count = 1;
		people = 0;
		for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < count; j++) {
				k2018[people]=k2018_money[i];
				people++;
			}
			count *= 2;
		}
		
		while(testcase-->0){
			int sum =0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a<22 && a!=0){
				sum+=k2017[a-1];
			}
			
			if(b<32 && b!=0){
				sum+=k2018[b-1];
			}
			
			sb.append(sum*10000).append("\n");
		}
		System.out.println(sb);
	}
}
