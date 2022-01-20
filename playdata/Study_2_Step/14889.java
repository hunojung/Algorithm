// 스타트와 링크
package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] team;
	static boolean[] ok;
	static int Min = Integer.MAX_VALUE; 
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력 
		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		ok = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				team[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		combi(0,0);
		System.out.println(Min);
		
		
		br.close();
		System.exit(0);
	}
	
	// idx는 인덱스, count는 재귀 깊이
	static void combi(int idx,int depth){
		
		if(depth==N/2){
			// ok 인 선수가 N/2 일때 팀 점수 비교
			diff();
			return;
			
		}else{				
			for (int i = idx; i < N; i++) {
				// 방문하지 않았다면 방문체크하고 들어간다
				if(!ok[i]){
					ok[i]=true;
					combi(i+1,depth+1);
					ok[i]=false;					
				}
			}
		}
	}
	
	// 두 팀 점수 차이 계산
	static void diff(){
		int start = 0;
		int link = 0;
		
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if(ok[i] && ok[j]){					
					start+=team[i][j];
					start+=team[j][i];
				}else if(!ok[i] && !ok[j]){
					link+=team[i][j];
					link+=team[j][i];					
				}
			}
		}
		
		int diff = Math.abs(start-link);
		if(diff == 0){
			System.out.println(0);
			System.exit(0);
		}
		
		Min = Math.min(Min, diff);
	}
}
