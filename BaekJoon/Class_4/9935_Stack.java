// https://www.acmicpc.net/problem/9935
// 문자열 폭발
// 버전 1 : 인덱스만 쓰기
import java.io.*;
import java.util.*;

// 예외
// A
// BA
public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String s = br.readLine();
		String b = br.readLine();
		char[] bomb = b.toCharArray();
		char[] result = new char[s.length()];
		int len = b.length();
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.length()<bomb.length)break;
			
			result[index] = s.charAt(i);
			index++;
			
			if(index>=len && result[index-1]==bomb[len-1]){
				
				boolean find = true;
				for (int j = 0; j < len; j++) {
					if(result[(index-1)-j]!=bomb[(len-1)-j]){
						find = false;
						break;
					}
				}
				if(find){
					index -= len;
				}
			}
		}
		
		if(index==0){
			sb.append("FRULA");
		}else{
			for (int i = 0; i < index; i++) {
				sb.append(result[i]);				
			}
		}
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
}

// 버전 2 스택 쓰기
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String s = br.readLine();
		String bomb = br.readLine();
		Deque<Character> stack = new ArrayDeque<>();
		Deque<Character> bombStack = new ArrayDeque<>();
		int len = bomb.length()-1;
		for (int i = 0; i < s.length(); i++) {
			if(s.length()<bomb.length())break;
			char next = s.charAt(i);
			stack.push(next);
			
			while(!stack.isEmpty() && stack.peek()==bomb.charAt(len)){
				bombStack.push(stack.pop());
				len--;
				if(len==-1){
					len = bomb.length()-1;
					bombStack.clear();
					break;
				}
			}
			
			if(len<bomb.length()-1){
				while(!bombStack.isEmpty()){
					stack.push(bombStack.pop());
					len++;
				}
			}
		}
		
		if(stack.isEmpty())sb.append("FRULA");
		else{
			while(!stack.isEmpty())
				sb.append(stack.pollLast());
		}
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
}
