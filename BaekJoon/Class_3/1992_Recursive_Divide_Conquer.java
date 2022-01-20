// 쿼드 트리
// 1992
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][] img;
	static String ans="";
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N= Integer.parseInt(br.readLine());
		img = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				img[i][j]=line.charAt(j)-'0';
			}
		}
		
		quad(N,0,0);
		if(ans.equals("(0000)"))System.out.println(0);
		else if(ans.equals("(1111)"))System.out.println(1);
		else System.out.println(ans);
		
		br.close();
		System.exit(0);
	}
	
	public static void quad(int N,int row,int col){
		ans+="(";
				
		// 4개로 나눔
		for (int k = 0; k < 4; k++) {
			if(k==1){
				col=col+N/2;
			}else if(k==2){
				row=row+N/2;
				col=col-N/2;
			}else if(k==3){
				col=col+N/2;
			}
			
			//System.out.println(N+" "+row+" "+col);
		
			int start = img[row][col];
			boolean same = true;
			for (int i = row; i < N/2+row; i++) {
				for (int j = col; j < N/2+col; j++) {
					if(img[i][j]!=start){
						same = false;
						break;
					}
				}
				if(!same)break;
			}
			
			if(same){
				if(start==0) ans+="0";
				else ans+="1";
			}else{
				quad(N/2,row,col);
			}
		}
		ans+=")";
	}
}
// 1992 END
