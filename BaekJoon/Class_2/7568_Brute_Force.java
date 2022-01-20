// 덩치
// 7568
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int[] height = new int[number];
		int[] weight = new int[number];
		int[] rank = new int[number];
		
		for (int i = 0; i < number; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			height[i] = Integer.parseInt(st.nextToken());
			weight[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < number-1; i++) {
			for (int j = i+1; j < number; j++) {
				if(height[i]>height[j] && weight[i]>weight[j]){
					rank[j]++;
				}else if(height[i]<height[j] && weight[i]<weight[j]){
					rank[i]++;
				}
			}
		}
		
		for (int i = 0; i < number; i++) {
			System.out.print((rank[i]+1)+" ");
		}
		
		br.close();
		System.exit(0);
	}
}
// 7568 END
