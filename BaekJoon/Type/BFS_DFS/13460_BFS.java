// https://www.acmicpc.net/problem/13460
import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = -1;
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		
		int[] red = new int[2];
		int[] blue = new int[2];
		int[] out = new int[2];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=line.charAt(j);
				if(map[i][j]=='R') {
					red = new int[] {i,j};
					map[i][j]='.';
				}
				if(map[i][j]=='B') {
					blue = new int[] {i,j};
					map[i][j]='.';
				}
				if(map[i][j]=='O') {
					out = new int[] {i,j};
				}
			}
		}
		
		boolean[][][][] visited = new boolean[N][M][N][M];
		visited[red[0]][red[1]][blue[0]][blue[1]]=true;
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(red,blue,0));

		int[] dn = {0,1,0,-1};
		int[] dm = {1,0,-1,0};
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			//System.out.println(now.red[0]+" "+now.red[1]+" "+now.blue[0]+" "+now.blue[1]);
			if(now.count>10) {
				break;
			}
			
			if(now.red[0]==out[0] && now.red[1]==out[1] && (now.blue[0]!=out[0] || now.blue[1]!=out[1])) {
				answer = now.count;
				break;
			}
			
			// 왼쪽 기울임
			for (int i = 0; i < 4; i++) {
				
				red[0]=now.red[0];
				red[1]=now.red[1];
				blue[0]=now.blue[0];
				blue[1]=now.blue[1];
				
				// red 구슬
				while(map[red[0]+dn[i]][red[1]+dm[i]]!='#') {
					red[0]+=dn[i];
					red[1]+=dm[i];
					if(map[red[0]][red[1]]=='O') break;
				}
				
				// blue 구슬
				while(map[blue[0]+dn[i]][blue[1]+dm[i]]!='#') {
					blue[0]+=dn[i];
					blue[1]+=dm[i];
					if(map[blue[0]][blue[1]]=='O') break;
				}
				
				if(blue[0]==out[0] && blue[1]==out[1]) continue;
					
				// red, blue 같을때
				if(red[0]==blue[0] && red[1]==blue[1]) {
					switch(i) {
					case 0: // 오른쪽
						if(now.red[1]>now.blue[1]) blue[1]--;
						else red[1]--;
						break;
					case 1: // 아래
						if(now.red[0]>now.blue[0]) blue[0]--;
						else red[0]--;
						break;
					case 2: // 왼쪽
						if(now.red[1]>now.blue[1]) red[1]++;
						else blue[1]++;
						break;
					case 3: // 위
						if(now.red[0]>now.blue[0]) red[0]++;
						else blue[0]++;
						break;
					}
				}
				
				if(!visited[red[0]][red[1]][blue[0]][blue[1]]) {
					q.add(new Point(red,blue,now.count+1));
					visited[red[0]][red[1]][blue[0]][blue[1]]=true;
				}
				
			}
		}
		
		System.out.println(answer);
		br.close();
		System.exit(0);
	}

}


class Point{
	int[] red = new int[2];
	int[] blue = new int[2];
	int count;
	public Point(int[] red , int[] blue , int count) {
		this.red[0] = red[0];
		this.red[1] = red[1];
		this.blue[0] = blue[0];
		this.blue[1] = blue[1];
		this.count = count;
	}
}
