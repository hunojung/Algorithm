// https://www.acmicpc.net/problem/5014
// 스타트링크
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		// 총F층
		// S->G층 이동 , U칸위로 D칸 아래로
		int button = 0;
		boolean arrive = false;
		boolean[] visit = new boolean[F+1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {S,button});
		while(!q.isEmpty()){
			// 현재 층, 버튼 누른 횟수
			int[] now = q.poll();
			if(now[0]==G){
				button=now[1];
				arrive = true;
				break;
			}
			if(now[0]+U<F+1 && !visit[now[0]+U]){
				q.add(new int[] {now[0]+U,now[1]+1});
				visit[now[0]+U]=true;
			}
			if(now[0]-D>0 && !visit[now[0]-D]){
				q.add(new int[] {now[0]-D,now[1]+1});
				visit[now[0]-D]=true;
			}
		}
		if(arrive)
			System.out.println(button);
		else
			System.out.println("use the stairs");
		br.close();
		System.exit(0);
	}
}
