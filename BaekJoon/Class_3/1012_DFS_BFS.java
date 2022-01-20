// 유기농배추
// DFS
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			
			// 배추 심기
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
			}
			
			int count = worm(N,M,0,0,map);
			System.out.println(count);
		}

		br.close();
		System.exit(0);
	}
	
	public static int worm(int N, int M, int x, int y, int[][] map){
		
		Stack<Integer> xStack = new Stack<>();
		Stack<Integer> yStack = new Stack<>();
		int count=0;
		
		while(y<M){
			if(map[x][y]==1){
				//System.out.println(map[x][y]+" "+x+" "+y+" "+count);
				count++;
				xStack.add(x);
				yStack.add(y);
				map[x][y]++;

				// 스택에 들어오면 이어서 계속 찾음
				while(!xStack.isEmpty()){	
					// x-1,y
					int xTest = xStack.pop();
					int yTest = yStack.pop();
					
					if(xTest-1 > -1 && map[xTest-1][yTest]==1){
						xStack.add(xTest-1);
						yStack.add(yTest);
						map[xTest-1][yTest]++;
						// x+1,y
					}
					if(xTest+1 < N && map[xTest+1][yTest]==1){
						xStack.add(xTest+1);
						yStack.add(yTest);
						map[xTest+1][yTest]++;
						// x,y-1
					}
					if(yTest-1 > -1 && map[xTest][yTest-1]==1){
						xStack.add(xTest);
						yStack.add(yTest-1);
						map[xTest][yTest-1]++;
						// x,y+1
					}
					if(yTest+1 < M && map[xTest][yTest+1]==1){
						xStack.add(xTest);
						yStack.add(yTest+1);
						map[xTest][yTest+1]++;
					}
				}
			}
			
			// 좌표 증가
			x++;
			if(x==N){
				y++;
				x=0;
			}
		}
		
		return count;
	}
}
// DFS END
// BFS
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			
			// 배추 심기
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
			}
			
			int count = worm(N,M,0,0,map);
			System.out.println(count);
		}

		br.close();
		System.exit(0);
	}
	
	public static int worm(int N, int M, int x, int y, int[][] map){
		
		Queue<Integer> xQ = new LinkedList<>();
		Queue<Integer> yQ = new LinkedList<>();
		int count=0;
		
		while(y<M){
			if(map[x][y]==1){
				//System.out.println(map[x][y]+" "+x+" "+y+" "+count);
				count++;
				xQ.add(x);
				yQ.add(y);
				map[x][y]++;

				// 스택에 들어오면 이어서 계속 찾음
				while(!xQ.isEmpty()){	
					// x-1,y
					int xTest = xQ.poll();
					int yTest = yQ.poll();
					
					if(xTest-1 > -1 && map[xTest-1][yTest]==1){
						xQ.add(xTest-1);
						yQ.add(yTest);
						map[xTest-1][yTest]++;
						// x+1,y
					}
					if(xTest+1 < N && map[xTest+1][yTest]==1){
						xQ.add(xTest+1);
						yQ.add(yTest);
						map[xTest+1][yTest]++;
						// x,y-1
					}
					if(yTest-1 > -1 && map[xTest][yTest-1]==1){
						xQ.add(xTest);
						yQ.add(yTest-1);
						map[xTest][yTest-1]++;
						// x,y+1
					}
					if(yTest+1 < M && map[xTest][yTest+1]==1){
						xQ.add(xTest);
						yQ.add(yTest+1);
						map[xTest][yTest+1]++;
					}
				}
			}
			
			// 좌표 증가
			x++;
			if(x==N){
				y++;
				x=0;
			}
		}
		
		return count;
	}
}
// BFS
