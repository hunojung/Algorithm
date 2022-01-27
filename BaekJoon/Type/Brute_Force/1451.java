// https://www.acmicpc.net/problem/1451
// 직사각형으로 나누기

// 분류
// 브루트포스 알고리즘
// 누적 합
import java.io.*;
import java.util.*;

public class Main{
	static int[][] map;
	static int[] num;
	static int N,M;
	static long answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		for (int i = 1; i < N+1; i++) {
			String s = br.readLine();
			for (int j = 1; j < M+1; j++) {
				int next = Integer.parseInt(s.charAt(j-1)+"");
				map[i][j]=next+map[i-1][j]+map[i][j-1]-map[i-1][j-1];
			}
		}
		
		if(M>2){
			num = new int[3];
			col3(0,1);
		}
		
		if(N>2){
			num = new int[3];
			row3(0,1);
		}
		
		if(M>1 && N>1){
			colrow21(0,1,1);
		}
		
		System.out.println(answer);
		br.close();
		System.exit(0);
	}
	
	static void colrow21(int depth,int col,int row){
		if(depth == 1){
				//System.out.println(s);
			return;
		}
		
		for (int i = row; i < N; i++) {
			for (int j = col; j < M; j++) {
				long s = (long)map[i][j]*(map[i][M]-map[i][j])*(map[N][M]-map[i][M]);
				long s1 = (long)map[i][M]*(map[N][j]-map[i][j])*(map[N][M]-map[i][M]-map[N][j]+map[i][j]);
				long s2 = (long)map[i][j]*(map[N][j]-map[i][j])*(map[N][M]-map[N][j]);
				long s3 = (long)map[N][j]*(map[i][M]-map[i][j])*(map[N][M]-map[i][M]-map[N][j]+map[i][j]);
				long max = Math.max(s, Math.max(s1, Math.max(s2, s3)));
				if(answer<max){
					answer = max;
				}
			}
		}
	}
	
	static void row3(int depth,int start){
		if(depth == 2){
			long s = (long)map[num[0]][M]*(map[num[1]][M]-map[num[0]][M])*(map[N][M]-map[num[1]][M]);
			if(s>answer)answer = s;
			//System.out.println(s);
			return;
		}
		
		for (int i = start; i < N-1+depth; i++) {
			num[depth]=i;
			row3(depth+1,i+1);
		}
	}
	
	static void col3(int depth,int start){
		
		if(depth == 2){
			//System.out.println(num[0]+" "+num[1]+" / "+map[N][num[0]]+" "+(map[N][num[1]]-map[N][num[0]])+" "+(map[N][M]-map[N][num[1]]));
			long s = (long)map[N][num[0]]*(map[N][num[1]]-map[N][num[0]])*(map[N][M]-map[N][num[1]]);
			if(s>answer)answer = s;
			//System.out.println(s);
			return;
		}
		
		for (int i = start; i < M-1+depth; i++) {
			num[depth]=i;
			col3(depth+1,i+1);
		}
	}
	
}
