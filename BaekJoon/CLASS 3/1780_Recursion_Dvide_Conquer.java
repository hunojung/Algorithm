// 종이의 개수
// 1780
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int a = 0;
	static int b = 0;
	static int c = 0;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		func(N,0,0);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		br.close();
		System.exit(0);
	}
	
	public static void func(int N, int row, int col){
		// 시작 숫자 획득
		int start = map[row][col];
		//System.out.println(start+" "+N+" "+row+" "+col);
		// 일치 여부
		boolean same = true;
		
		// 일치하는지 비교
		for (int i = row; i < row+N; i++) {
			for (int j = col; j < col+N; j++) {
				
				if(start != map[i][j]){
					same = false;
					break;
				}
			}
			if(same==false)break;
		}
		
		// 일치 여부에 따라 숫자세기 or 나누기
		if(same==false){
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					func(N/3,row+i*N/3,col+j*N/3);
				}
			}
			
		}else{
			//System.out.println("count ="+N);
			if(start == -1)a++;
			if(start == 0)b++;
			if(start == 1)c++;
		}
	}
}
// 1780 END
