// 테트로미노
// 11450
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] te;
	static int N, M;
	// 가로 3 세로 1인 것들
	static int[][][] t1 = {{{0,0},{0,1},{0,2},{1,0}},//ㄱ
			{{0,0},{0,1},{0,2},{1,2}},
			{{1,0},{1,1},{1,2},{0,0}},
			{{1,0},{1,1},{1,2},{0,2}},
			{{0,0},{0,1},{0,2},{1,1}},//ㅗ
			{{1,0},{1,1},{1,2},{0,1}},
			{{1,0},{1,1},{0,1},{0,2}},// z
			{{0,0},{0,1},{1,1},{1,2}}
		};

	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	
		M = Integer.parseInt(st.nextToken());
		
		te = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				te[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(poly());
		
		br.close();
		System.exit(0);
	}
	
	static int poly(){
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int[] number = new int[21];
				
				// ㅣ
				if(i<N-3){
					for (int k = 0; k < 4; k++) {
						number[0] += te[i+k][j];
					}
				}
				
				// ㅡ
				if(j<N-3){
					for (int k = 0; k < 4; k++) {
						number[1] += te[i][j+k];
					}
				}
				
				// ㅁ
				if(i<N-1 && j<N-1){
					number[2]= te[i][j]+te[i+1][j]+te[i][j+1]+te[i+1][j+1];
				}
				
				// ㄱ, ㅗ , z 누운거 총 8개
				if(i<N-1 && j<N-2){
					for (int k = 0; k < 8; k++) {
						for (int l = 0; l < 4; l++) {
							number[k+3] += te[i+t1[k][l][0]][j+t1[k][l][1]];
						}
					}
				}
				
				// ㄱ, ㅗ, z 서있는거 총 8개
				if(i<N-2 && j<N-1){
					for (int k = 0; k < 8; k++) {
						for (int l = 0; l < 4; l++) {
							number[k+11] += te[i+t1[k][l][1]][j+t1[k][l][0]];
						}
					}
				}
				
				for (int k = 0; k < 21; k++) {
					if(max<number[k])max=number[k];
				}
			}
		}
		return max;
	}
}
// 11450 END
