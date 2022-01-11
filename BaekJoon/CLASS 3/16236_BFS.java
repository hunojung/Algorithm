// 아기상어
// 16236
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] fish; 
	static int N;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력
		N = Integer.parseInt(br.readLine());
		fish = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				fish[i][j]=num;
			}
		}
		
		//출력
		System.out.println(feedSearch());
		br.close();
		System.exit(0);
	}
	
	// 찾기
	static int feedSearch(){
		
		Shark s = null;
		int count = 0;
		// 아기 상어 생성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(fish[i][j]==9){
					s = new Shark(new Point(i,j,0));
					fish[i][j]=0;
				}
			}
		}
		// search(s)가 null일 때 까지 와일문
		while(true){
			Point p = search(s);
			
			if(p==null)break;
			//System.out.println("search 결과: "+p.x+" "+p.y+" / 거리 : "+p.depth+" / body :"+s.body);
			
			s.eat();
			fish[p.x][p.y]=0;
			
			count+= p.depth;
			p.depth = 0;
			s.p = p;
		}
		
		return count;
	}
	
	// 먹이 찾기
	static Point search(Shark s){
				
		Queue<Point> q = new LinkedList<>();
		Point p = s.p;
		q.add(p);

		// 가까운 먹이 좌표 저장
		Point target = null;
		
		//직전 까지 거리
		int depthBefore = 0;

		// 방문 여부
		int[][] ok = new int[N][N];
		ok[p.x][p.y]=1;
		
		// 먹이 찾자
		while(!q.isEmpty()){
			p = q.poll();
			//System.out.println("search 과정: "+p.x+" "+p.y+" "+p.depth);
			
			// depth가 바꼈을때 가까운 먹이가 null이 아니면 break; 
			if(depthBefore != p.depth){
				if(target!=null)break;
				
				depthBefore = p.depth;				
			}
			
			// 상어보다 작은 먹이가 있으면 삽입, 좌표비교
			if(fish[p.x][p.y]!=0 && fish[p.x][p.y]<s.body){
				if(target==null){
					//System.out.println("target 삽입! : "+p.x+" "+p.y+" "+p.depth);
					target = new Point(p.x,p.y,p.depth);
				}else{
					if(target.x>p.x){
						target = new Point(p.x,p.y,p.depth);
					}else if(target.x == p.x && target.y>p.y){
						target = new Point(p.x,p.y,p.depth);
					}
				}
			}
			
			// 찾아가기
			p.depth++;
			
			// 좌표가 안넘고 / 왔던곳 안가고 / 몸크기 큰건 못감
			if(p.x>0 && ok[p.x-1][p.y]==0 && fish[p.x-1][p.y]<=s.body){
				ok[p.x-1][p.y]=1;
				q.add(new Point(p.x-1,p.y,p.depth));
			}
			if(p.y>0 && ok[p.x][p.y-1]==0 && fish[p.x][p.y-1]<=s.body){
				ok[p.x][p.y-1]=1;
				q.add(new Point(p.x,p.y-1,p.depth));
			}
			if(p.x+1<N && ok[p.x+1][p.y]==0 && fish[p.x+1][p.y]<=s.body){
				ok[p.x+1][p.y]=1;
				q.add(new Point(p.x+1,p.y,p.depth));
			}
			if(p.y+1<N && ok[p.x][p.y+1]==0 && fish[p.x][p.y+1]<=s.body){
				ok[p.x][p.y+1]=1;
				q.add(new Point(p.x,p.y+1,p.depth));
			}
		}
		
		return target;
	}
	
	// 위치 정보
	static class Point{
		int x;
		int y;
		int depth;
		
		Point(int x, int y,int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
	
	// 상어
	static class Shark{
		
		// 몸집 크기
		int body;
		// 먹이 먹은 수
		int peed;

		Point p;
		
		public Shark(Point p) {
			this.body = 2;
			this.peed = 0;
			
			this.p = p;
		}
		
		// 상어가 먹이먹는다
		public void eat(){
			peed++;
			if(peed==body){
				peed = 0;
				body++;
			}
		}
	}
}
// 16236 END
