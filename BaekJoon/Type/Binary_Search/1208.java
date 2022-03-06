// https://www.acmicpc.net/problem/1208
// 부분수열의 합 2
import java.io.*;
import java.util.*;

//40 0
//100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000 -100000
//
//정답 : 137846528819
public class Main {
	static int[] nums;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		// left, right 모두 0이 포함 되기 때문에
		// 각각에 대한 합도 비교할 수 있게 된다.
		dfs(0,N/2,0,left);
		dfs(N/2,N,0,right);
		
		Collections.sort(right);
		long ans = 0;
		for(int val : left){
			val = S-val;
			int hiIdx = upper_bound(right,val);
			int loIdx = lower_bound(right,val);
			ans+=hiIdx-loIdx;
		}
		if(S==0)
			ans--;
		System.out.println(ans);
		
		br.close();
		System.exit(0);
	}
	
	static int lower_bound(List<Integer> list,int val){
		int l = 0 , r = list.size()-1;
		while(l<=r){
			int mid = (l+r)/2;
			if(list.get(mid)>=val){
				r=mid-1;
			}else{
				l=mid+1;
			}
		}
		return l;
	}
	
	static int upper_bound(List<Integer> list,int val){
		int l = 0 , r = list.size()-1;
		while(l<=r){
			int mid = (l+r)/2;
			if(list.get(mid)>val){
				r=mid-1;
			}else{
				l=mid+1;
			}
		}
		return l;
	}
	
	static void dfs(int idx,int end,int sum,List<Integer> list){
		if(idx==end){
			list.add(sum);
			return;
		}
		
		dfs(idx+1,end,sum+nums[idx],list);
		dfs(idx+1,end,sum,list);
	}
}
