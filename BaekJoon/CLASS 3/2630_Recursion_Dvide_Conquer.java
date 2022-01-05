// 색종이 만들기
// 2630
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] paper;
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N= Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		cut(N,0,0);
		System.out.println(white+"\n"+blue);
		
		
		br.close();
		System.exit(0);
	}
	
	public static void cut(int N, int row, int col){
		//System.out.println(N+" "+row+" "+col);
		int start = paper[row][col];
		boolean same = true;
		
		for (int i = row; i < N+row; i++) {
			for (int j = col; j < N+col; j++) {
				if(start != paper[i][j]){
					same=false;
					break;
				}
			}
			if(!same)break;
		}
		
		if(same){
			if(start == 0) white ++;
			else blue ++;
		}else{
			cut(N/2,row,col);
			cut(N/2,row,N/2+col);
			cut(N/2,N/2+row,col);
			cut(N/2,N/2+row,N/2+col);
		}
	}
}
// 2630 END
