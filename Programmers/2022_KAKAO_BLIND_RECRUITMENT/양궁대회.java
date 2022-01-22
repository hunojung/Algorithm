// https://programmers.co.kr/learn/courses/30/lessons/92342
// 양궁대회

// Back-Tracking
package algorithm;

import java.io.*;
import java.util.*;

public class Solution{
	
	public static void main(String[] args) {
		int[] testa = {0,0,0,0,0,0,0,0,3,4,3};
		int[] test = new Solution().solution(10, testa);
		
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]+",");
		}
	}
	
    static int[] a;
    static int N;
    static int[] b = new int[11]; // 라이언이 맞춘 과녁
    static int[] ans = new int[11]; // 정답 저장할 배열
    static int compareSum = Integer.MIN_VALUE;
    public int[] solution(int n, int[] info) {
        a = info;
        N = n;
        
        dfs(0,0);
        
        if(compareSum<=0)return new int []{-1};
        
        return ans;
    }
    
    static void dfs(int count,int index){
    	
    	// 화살 다 쓰면 두명 점수 비교
    	int score = comp();
    	// 과녁 갯수와 상관없이 점수 비교하고 크면 바꿈
    	if(score>compareSum && score>0){
			compareSum=score;
			if(compareSum>0)
				changeAns();
    		
    	// 같으면 바꿀지 고민후 바꿈
    	}else if(score == compareSum){
    			
			// 더 낮은 과녁이 많은지 확인
			comfirmAns();
		}
    		
    	// depth = 과녁 아직 다 안쏨
    	
    	if(count<N){
	    	
	    	// 과녁 11개 모두 돌자
			if(index<11){
				if(a[index]+1<=(N-count)){
					b[index]+=a[index]+1;
					dfs(count+a[index]+1,index+1);
					b[index]-=(a[index]+1);	    			
				}
				dfs(count,index+1);
			}
    	}
    }
    
    // 답이 낮은과녁이 많은지 확인하고 바꾸기
    static void comfirmAns(){
    	// true = 바꾼다
    	boolean good = false;
    	for (int i = 10; i > -1; i--) {
    		if(ans[i]==b[i]){
    			continue;
    		}else if(ans[i]<b[i]){
    			good=true;
    			break;
    		}else{
    			break;
    		}
		}
    	
    	// 바꿔도 되겠다
    	if(good){
    		for (int i = 0; i < 11; i++) {
				ans[i]=b[i];
			}
    	}
    }
    
    static void changeAns(){
    	for (int i = 0; i < 11; i++) {
			ans[i]=b[i];
		}
    	int sum = Arrays.stream(ans).sum();
    	if(sum<N)ans[10]+=N-sum;
    }
    
    // 두명 점수 비교
    static int comp(){
    	int sum = 0;
    	for (int i = 0; i < 11; i++) {
    		if(a[i]>b[i]){
				sum -= (10-i);
			}else if(a[i]<b[i]){
				sum += (10-i);
			}
		}
    	return sum;
    }
}
