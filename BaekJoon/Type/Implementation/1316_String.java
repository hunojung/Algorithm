// https://www.acmicpc.net/problem/1316
// 그룹 단어 체커

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
        int testcase = Integer.parseInt(br.readLine());
        int answer = 0;
        while(testcase-->0){
	        // 입력
        	boolean[] check = new boolean[26];
        	boolean group = true;
        	String s = br.readLine();
        	char before_c=' ';
        	for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if(before_c == c)continue;

				if(check[c-'a']){
					group = false;
					break;
				}else{
					check[c-'a']=true;
					before_c=c;
				}
			}
        	if(group)answer++;
	        
        }
        System.out.println(answer);
        br.close();
		System.exit(0);
	}
}
