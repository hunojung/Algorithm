// https://www.acmicpc.net/problem/2941
// 크로아티아 알파벳

// 분류
// 구현
// 문자열
import java.io.*;
import java.util.*;

public class Main{
	static int N;
	static int[] dx = {2,1,-1,-2,-2,-1,1,2};
	static int[] dy = {1,2,2,1,-1,-2,-2,-1};
	
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
    	String s = br.readLine();
    	int answer = 0;
    	for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			answer++;
			if((c=='c' || c=='s' || c=='z') && i<s.length()-1){
				if(s.charAt(i+1)=='='){
					i++;
				}else if(c=='c' && s.charAt(i+1)=='-'){
					i++;
				}
			}else if(c=='d'){
				if(i<s.length()-1 && s.charAt(i+1)=='-'){
					i++;
				}else if(i<s.length()-2 && (s.charAt(i+1)=='z' && s.charAt(i+2)=='=')){
					i+=2;
				}
			}else if (c=='l' || c=='n'){
				if(i<s.length()-1 && s.charAt(i+1)=='j'){
					i++;
				}
			}
		}
	        
        System.out.println(answer);
        br.close();
		System.exit(0);
	}
}
