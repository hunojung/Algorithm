// https://www.acmicpc.net/problem/1034
// 램프

// 분류
// 브루트포스 알고리즘
// 애드 혹
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W,H,N,answer=0;
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[H][W];
		String[] s = new String[H]; // 나중에 비교하기 쉽게 하나 만들어둠
		for (int i = 0; i < H; i++) {
			s[i] = br.readLine();
			for (int j = 0; j < W; j++) {
				map[i][j]=Integer.parseInt(s[i].charAt(j)+"");
			}
		}
		
		N = Integer.parseInt(br.readLine());
		
		// 완료 될 수 있는 행은 ok 한다
		boolean[] ok = new boolean[H];
		for (int i = 0; i < H; i++) {
			
			// 열크기 - i행의 1의 갯수 = 0의 갯수
			int cnt = W-Arrays.stream(map[i]).sum();
			
			// 0의 갯수가 N보다 작으면서 짝,홀이 N과 같을때
			if(cnt<=N && cnt%2==N%2){
				ok[i]=true;
			}
		}
		
		for (int i = 0; i < H; i++) {
			if(ok[i]){
			int cnt=0;
				for (int j = 0; j < H; j++) {
					
					// 초기상태가 같은 행을 찾는다
					// 초기상태가 같아야 i행이랑 같이 불이켜진다.
					if(s[i].equals(s[j])){
						cnt++;
						//System.out.println(i+" "+j);
					}
				}
				if(answer<cnt)answer=cnt;
			}
		}
		
		System.out.println(answer);
		br.close();
		System.exit(0);
	}
}
