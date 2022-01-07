// 경로 찾기
// 11403
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] m = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// i → k → j
		// k : 거쳐가는 노드 
		for(int k=0; k<N; k++) {
			// i : 출발 노드
			for(int i=0; i<N; i++) {
				// j : 도착 노드 
				for(int j=0; j<N; j++) {
					if(m[i][k] ==1 && m[k][j] ==1) {
						m[i][j] =1;
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(m[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

		
		br.close();
		System.exit(0);
	}
}
// 11403 END
