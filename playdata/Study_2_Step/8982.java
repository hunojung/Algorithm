// 사냥꾼
import java.io.*;
import java.util.*;

public class Main {
	static int[] gun;
	static int[][] ani;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		gun = new int[M];
		ani = new int[N][2];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			gun[i]=Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			ani[i][0]= Integer.parseInt(st.nextToken());
			ani[i][1]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(gun);
		
		System.out.println(bi_search(M,N,L));
		
		br.close();
		System.exit(0);
	}
	
	static int bi_search(int M,int N,int L){
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(ani[i][1]>L)continue;
			
			int start = 0;
			int	end = M;
			int mid = 0;
			int dist = 0;
			while(start<=end){
				mid = (start+end)/2;
				if(mid>=M) break;
				
				dist = Math.abs(ani[i][0]-gun[mid])+Math.abs(ani[i][1]);
				
				if(L < dist && ani[i][0] < gun[mid]){
					end = mid-1;
				}else if(L < dist && ani[i][0]>gun[mid]){
					start = mid+1;
				}else if(L >= dist){
					count++;
					break;
				}
			}
		}
		return count;
	}
}
