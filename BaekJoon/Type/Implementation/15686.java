// https://www.acmicpc.net/problem/15686
// 치킨 배달

// 분류
// 구현
// 브루트포스 알고리즘
import java.io.*;
import java.util.*;

public class Main{
	static int count1=0,count2=0,answer= Integer.MAX_VALUE;
	static int N,M;
	static int[][] cost;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	List<int[]> list2 = new ArrayList<>();
    	List<int[]> list1 = new ArrayList<>();
    	
    	for (int i = 0; i < N; i++) {
    		st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int cost=Integer.parseInt(st.nextToken());
				if(cost==2){
					list2.add(new int[] {i,j});
					count2++;
				}else if(cost==1){
					list1.add(new int[] {i,j});
					count1++;
				}
			}
		}
    	
    	cost = new int[count1][count2];
    	for (int i = 0; i < count1; i++) {
			int[] one = list1.get(i);
			for (int j = 0; j < count2; j++) {
				int[] two = list2.get(j);
				cost[i][j]=Math.abs(one[0]-two[0])+Math.abs(one[1]-two[1]);
			}
		}
    	boolean[] visit=new boolean[count2];
    	dfs(visit,0,0);
    	
        System.out.println(answer);
        br.close();
		System.exit(0);
	}
	
	static void dfs(boolean[] visit,int count,int start){
		
		if(count==M){
			int sum = 0;
			for (int i = 0; i < count1; i++) {
				int min=Integer.MAX_VALUE;
				for (int j = 0; j < count2; j++) {
					if(visit[j] && cost[i][j]<min)min=cost[i][j];
				}
				sum+=min;
			}
			if(sum<answer)answer=sum;
			return;
		}
		
		if(start == count2)return;
		
		dfs(visit,count,start+1);
		visit[start]=true;
		dfs(visit,count+1,start+1);
		visit[start]=false;
	}
}
