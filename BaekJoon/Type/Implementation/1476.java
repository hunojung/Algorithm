// https://www.acmicpc.net/problem/1476
// 날짜 계산
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E2 = Integer.parseInt(st.nextToken());
		int S2 = Integer.parseInt(st.nextToken());
		int M2 = Integer.parseInt(st.nextToken());
		int E = 1, S = 1, M = 1;
		int answer = 1;
		while(E!=E2 || S!=S2 || M!= M2){
			E++;
			S++;
			M++;
			if(E==16)E=1;
			if(S==29)S=1;
			if(M==20)M=1;
			answer++;
		}
		System.out.println(answer);
		//br.close();
		System.exit(0);
	}
}
