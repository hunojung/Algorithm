// https://www.acmicpc.net/problem/21966
// (중략)

// 분류
// 구현
// 문자열
// 많은 조건 분기
import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    	int N = Integer.parseInt(br.readLine());
    	String s1 = br.readLine();
		
    	if(s1.length()<26){
    		System.out.println(s1);
    	}else{
    		
    		String s2 = s1.substring(11,s1.length()-12);
    		if(s2.contains(".")){
    			System.out.println(s1.substring(0,9)+"......"+s1.substring(s1.length()-10,s1.length()));
    		}else{
    			System.out.println(s1.substring(0,11)+"..."+s1.substring(s1.length()-11,s1.length()));
    		}
    	}
		br.close();
		System.exit(0);
	}
}
