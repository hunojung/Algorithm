// N과 M (2)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] ans = new int[M];
		
		for (int i = 0; i < M; i++) {
			ans[i]=i+1;
			sb.append(ans[i]+" ");
		}
		sb.append("\n");
		
		while(true){
			ans = arr(ans,N,M);
			if(ans==null)break;
			for (int j = 0; j < M; j++) {
				sb.append(ans[j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	static int[] arr(int[] arr, int N,int M){
		
		int index = M-1;
		int[] ans = arr.clone();
		ans[index]++;
		//System.out.println(ans[index]+" "+index);
		while(true){
			
			if(ans[index]>N){
				
				index--;
				if(index<0)return null;
				ans[index]++;
			}else if(index < M-1){
				index++;
				ans[index]=ans[index-1]+1;
			}else if(index == M-1){
				break;
			}
		}
		return ans;
	}
}
