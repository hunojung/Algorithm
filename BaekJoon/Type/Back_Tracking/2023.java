// https://www.acmicpc.net/problem/2023
// 신기한 소수

// 분류
// 수학
// 정수론
// 백트래킹
// 소수 판정
import java.io.*;
import java.util.*;

public class Main{
    static int[] num;
    static int N;
    
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception{
		
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	bt(0);
    	
    	br.close();
    	System.exit(0);
	}
    
    static boolean isPrime(int n){
    	boolean ans = true;
    	if(n==1){
    		return false;
    	}
    	
    	if(n==2 || n==3 || n==5 || n==7){
    		return true;
    	}
    	
    	for (int i = 2; i < Math.sqrt(n)+1; i++) {
			if(n%i==0){
				ans=false;
				break;
			}
		}
    	return ans;
    }
    
    static void bt(int depth){
    	
    	if(depth == N){
    		//System.out.println(arr.get(0)+" "+arr.get(1)+" "+arr.get(2)+" "+arr.get(3));
    		int s = 0;
    		boolean p = true;
    		for (int i = 0; i < N; i++) {
    			s = ((s*10)+arr.get(i));
    			if(!isPrime(s)){
    				p=false;
    				break;
    			}
			}
    		
    		if(p){    			
				System.out.println(s);
    		}
    		
    	}else{
    		
    		for (int i = 0; i < 10; i++) {
				
    			if(depth != 0 || i != 0){
	    			arr.add(i);
	    			bt(depth+1);
	    			arr.remove(arr.size()-1);
				}
			}
    	}
    }
}
