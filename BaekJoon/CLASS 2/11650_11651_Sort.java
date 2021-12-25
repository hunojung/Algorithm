// 좌표 정렬하기
// 11650
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		Point[] p = new Point[testcase];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i]= new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(p);
		for (int i = 0; i < testcase; i++) {
			sb.append(p[i].x).append(" ").append(p[i].y).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	public static class Point implements Comparable<Point>{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			
			if(this.x == o.x){
				return this.y - o.y;
			}else{
				return this.x - o.x;
			}
		}
		
	}
}
// 11650 END

// 좌표 정렬하기 2
// 11651
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		Point[] p = new Point[testcase];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < testcase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i]= new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(p);
		for (int i = 0; i < testcase; i++) {
			sb.append(p[i].x).append(" ").append(p[i].y).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	public static class Point implements Comparable<Point>{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			
			if(this.y == o.y){
				return this.x - o.x;
			}else{
				return this.y - o.y;
			}
		}
		
	}
}
// 11651 END
