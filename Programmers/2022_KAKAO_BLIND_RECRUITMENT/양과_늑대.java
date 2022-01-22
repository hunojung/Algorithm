// https://programmers.co.kr/learn/courses/30/lessons/92343
// 양과 늑대

// 백트래킹
// DFS
import java.io.*;
import java.util.*;

public class Solution{
	
	static List<Integer>[] list;
	static int N;
	static int[] infoGet;
	static int answer = 0;
    public int solution(int[] info, int[][] edges) {
    	N = info.length;
        // 양은 1 늑대는 -1로 바꿈
        for (int i = 0; i < N; i++) {
        	if(info[i]==0){
        		info[i]=1;
        	}else{
        		info[i]=-1;
        	}
        }
        
        infoGet = info.clone();
        for (int i = 0; i < N; i++) {
		}
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
			list[i]= new ArrayList<>();
		}
        
        // list에 노드와 비용 추가
        // 0부터 시작이니까 0번노드 0
        for (int i = 0; i < edges.length; i++) {
        	int a = edges[i][0];
        	int b = edges[i][1];
			list[a].add(b);
			list[b].add(a);
		}
        
        // visit 같이 생성해서 들어가기
        boolean[] visit = new boolean[N];
        boolean reset = false;
        
        // 0번노드 양이니까 1로 시작?
        // start 번호가 양위치니까
        infoGet[0]=0;
        dfs(0,1,1,visit,true);
        
        return answer;
    }
    
    static void dfs(int start,int sheep,int sum,boolean[] visit, boolean reset){
    	
    	// 만약 양위치면 여기서부터 visit 초기화하고 한번 다시 훑어본다
    	//System.out.println("start : "+start+"infoGet[start] : "+infoGet[start]);
    	if(reset){
    		visit = new boolean[N];
    		visit[start]=true;
    	}
    	
    	//양 최댓값 갱신
    	if(sheep>answer){
    		answer=sheep;
    	}
    	
    	// 현재 노드에서 갈수있는곳 다 훑기
    	for (int i = 0; i < list[start].size(); i++) {
    		int next = list[start].get(i);
    		int add = infoGet[next];
    		// 안들린곳이면 가본다.
    		if(!visit[next] && sum+add>0){
    			
    			// 양이면 reset해주고 sheep++ 해준다.
    			if(add==1){
    				reset = true;
    				sheep++;
    			}else{
    				reset = false;
    			}
    			infoGet[next]-=add;
    			visit[next]=true;
    			
    			dfs(next,sheep,sum+add,visit,reset);
    			
    			infoGet[next]+=add;
    			visit[next]=false;
    			// 양이었으면 돌아왔을때 양-- 해준다.
    			if(add==1){
    				sheep--;
    			}
    		}
		}
    }
}
