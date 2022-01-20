// https://www.acmicpc.net/problem/6198
// 옥상 정원 꾸미기

// 분류
// 자료 구조
// 스택
import java.io.*;
import java.util.*;

public class Main{
    
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws Exception{
		
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	
    	// 스택을 쌓고 센다
    	long count=0;
    	Stack<Integer> s = new Stack<>();
    	int next=Integer.parseInt(br.readLine());
    	s.add(next);
    	for (int i = 0; i < N-1; i++) {
    		next=Integer.parseInt(br.readLine());
    		
    		while(!s.isEmpty() && s.peek()<=next){
    			s.pop();
    		}
    		count+=s.size();
    		s.add(next);
		}
    	
    	System.out.println(count);
    	br.close();
    	System.exit(0);
	}
}
