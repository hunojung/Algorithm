// https://www.acmicpc.net/problem/1004
// 어린 왕자

// 분류
// 기하학
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int N = Integer.parseInt(br.readLine());
			int[][] xyr = new int[N][3];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				xyr[i][0]=x;
				xyr[i][1]=y;
				xyr[i][2]=r;
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				double len1=Math.sqrt((x1-xyr[i][0])*(x1-xyr[i][0]) + (y1-xyr[i][1])*(y1-xyr[i][1]));
				double len2=Math.sqrt((x2-xyr[i][0])*(x2-xyr[i][0]) + (y2-xyr[i][1])*(y2-xyr[i][1]));
				if((len1<xyr[i][2] && len2>xyr[i][2]) ||(len1>xyr[i][2] && len2<xyr[i][2])){
					count++;
				}
			}
			sb.append(count+"\n");
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}
