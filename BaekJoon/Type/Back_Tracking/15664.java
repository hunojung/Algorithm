// https://www.acmicpc.net/problem/15664
// N과 M (10)

// 분류
// 백트래킹
import java.io.*;
import java.util.*;

public class Main{
    static int[] num;
    static int N,M;
    static ArrayList<Integer> arr = new ArrayList<>();
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception{
		
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	num = new int[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++) {
    		num[i]=Integer.parseInt(st.nextToken());
		}
    	
    	Arrays.sort(num);
    	
    	bt(0,0);
    	
    	br.close();
    	System.exit(0);
	}
    
    static void bt(int depth, int start){
    	
    	if(depth == M){
    		String s = "";
    		for (int i = 0; i < M; i++) {
    			if(i>0)s+=" ";
    			s +=arr.get(i);
			}
    		if(!set.contains(s)){
    			System.out.println(s);
    			set.add(s);
    		}
    		
    	}else{
    		
    		for (int i = start; i < N; i++) {
				
    			arr.add(num[i]);
    			bt(depth+1,i+1);
    			arr.remove(arr.size()-1);
			  }
    	}
}
