// https://www.acmicpc.net/problem/1918
// 후위 표기식

// 분류
// 자료구조
// 스택
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		String answer = "";
		Stack<Character> stack = new Stack<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char next = s.charAt(i);
			
			// 연산자 push
			if(next=='*' || next=='/'){

				// 이전 연산자가 *,/면 한번 push
				if(!stack.isEmpty() && (stack.peek()=='*' || stack.peek()=='/')){
					answer+=stack.pop();
				}
				stack.push(next);
			}else if( next=='+' || next=='-'){
				
				// 이전 연산자가 +,-면 한번 push
				if(!stack.isEmpty() && (stack.peek()=='+' || stack.peek()=='-')){
					answer+=stack.pop();
					
				// 이전 연산자가 *,/ 면 다 push
				}else if(!stack.isEmpty() && (stack.peek()=='*' || stack.peek()=='/')){
					// 괄호가 닫히거나 stack이 빌때까지
					while(!stack.isEmpty() && stack.peek()!='('){
						answer+=stack.pop();
					}
				}
				stack.push(next);
				
			// 괄호 열리면 몇개인지 세고 push
			}else if(next=='('){
				stack.push(next);
				count++;
				
			// 괄호 닫히면 열림 나올 때까지 pop
			}else if(next==')'){
				while(stack.peek()!='('){
					answer+=stack.pop();
				}
				stack.pop();
				count--;

			// 문자는 나올 때마다 추가
			}else{
				answer+=next;
			}
		}
		
		// 남은거 다 추가
		while(!stack.isEmpty()){
			answer+=stack.pop();
		}
		System.out.println(answer);
		
		br.close();
		System.exit(0);
	}
}
