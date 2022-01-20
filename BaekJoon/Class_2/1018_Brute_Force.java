// 체스판 다시 칠하기
// 1018
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());

		String[] BS = new String[8];
		String[] chess = new String[row];
		
		int countB = 0; // 시작 B 체스판과 다른 갯수
		int countW = 0; // 시작 W 체스판과 다른 갯수
		
		for (int i = 0; i < row; i++) { // 비교할 디폴트 체스판 생성
			chess[i] = br.readLine();
			if(i<8)
				if(i%2==0)BS[i]="BWBWBWBW";
				else BS[i]="WBWBWBWB";
			
		}
		
		int min = 64;
		for (int i = 0; i < row-7; i++) { // 8X8 들어갈 수 있는 모든 곳 비교
			for (int j = 0; j < col-7; j++) { 
        
				countB=0;
				countW=0;
        
				for (int i2 = 0; i2 < 8; i2++) { // 디폴트 체스판과 비교
					for (int j2 = 0; j2 < 8; j2++) {
            
						if(chess[i+i2].charAt(j+j2)==BS[i2].charAt(j2)){ // 디폴트 체스판과 다른 갯수
							countW++;
						}else{
							countB++;
						}
            
					}
				}
        
				int minNum = countW<countB?countW:countB;
				if(min>minNum)min = minNum;
			}
		}
		
		System.out.println(min);
		
		br.close();
		System.exit(0);
	}
}
// 1018 end
