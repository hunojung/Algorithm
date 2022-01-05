// 다지번호 붙이기
// BFS
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[][] house;
	static boolean[][] visit;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N= Integer.parseInt(br.readLine());
		house = new int[N][N]; // 0으로 초기화됨
		visit = new boolean[N][N]; // false로 초기화됨
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String a = br.readLine();
			for (int j = 0; j < N; j++) {
				house[i][j]=a.charAt(j)-'0';
			}
		}
		
		bfs(N);
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(list.size());
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	public static void bfs(int N){
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(house[i][j]==1 && !visit[i][j]){
					int count = 0;
					q.add(i);
					q.add(j);
					visit[i][j]=true;
					
					while(!q.isEmpty()){
						count++;
						int x = q.poll();
						int y = q.poll();
						//System.out.println(x+" "+y);
						
						if(x > 0 && house[x-1][y] == 1 && !visit[x-1][y]){
							q.add(x-1);
							q.add(y);
							visit[x-1][y] = true;
						}
						if(x+1 < N && house[x+1][y] == 1 && !visit[x+1][y]){
							q.add(x+1);
							q.add(y);
							visit[x+1][y] = true;
						}
						if(y > 0 && house[x][y-1] == 1 && !visit[x][y-1]){
							q.add(x);
							q.add(y-1);
							visit[x][y-1] = true;
						}
						if(y+1 < N && house[x][y+1] == 1 && !visit[x][y+1]){
							q.add(x);
							q.add(y+1);
							visit[x][y+1] = true;
						}
					}
					
					list.add(count);
				}
			}
		}
	}
}
// BFS END

// DFS
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {
	
	static int[][] house;
	static boolean[][] visit;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N= Integer.parseInt(br.readLine());
		house = new int[N][N]; // 0으로 초기화됨
		visit = new boolean[N][N]; // false로 초기화됨
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String a = br.readLine();
			for (int j = 0; j < N; j++) {
				house[i][j]=a.charAt(j)-'0';
			}
		}
		
		bfs(N);
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(list.size());
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	public static void bfs(int N){
		
		Stack<Integer> s = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(house[i][j]==1 && !visit[i][j]){
					int count = 0;
					s.push(i);
					s.push(j);
					visit[i][j] = true;
					
					while(!s.isEmpty()){
						count++;
						
						// queue 일 때랑 순서 반대
						int y = s.pop();
						int x = s.pop();
						//System.out.println(x+" "+y);
						
						if(x > 0 && house[x-1][y] == 1 && !visit[x-1][y]){
							s.push(x-1);
							s.push(y);
							visit[x-1][y] = true;
						}
						if(x+1 < N && house[x+1][y] == 1 && !visit[x+1][y]){
							s.push(x+1);
							s.push(y);
							visit[x+1][y] = true;
						}
						if(y > 0 && house[x][y-1] == 1 && !visit[x][y-1]){
							s.push(x);
							s.push(y-1);
							visit[x][y-1] = true;
						}
						if(y+1 < N && house[x][y+1] == 1 && !visit[x][y+1]){
							s.push(x);
							s.push(y+1);
							visit[x][y+1] = true;
						}
					}
					
					list.add(count);
				}
			}
		}
	}
}
// DFS END
