// https://www.acmicpc.net/problem/1406
// 에디터

// 분류
// 자료 구조
// 스택
// 연결 리스트
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		Stack<Character> stack_left = new Stack<>();
		Stack<Character> stack_right = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			stack_left.push(s.charAt(i));
		}
		int N = Integer.parseInt(br.readLine());
		int cursor = stack_left.size();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if(command.equals("L")){
				if(!stack_left.isEmpty())
					stack_right.push(stack_left.pop());
			}else if(command.equals("D")){
				if(!stack_right.isEmpty())
					stack_left.push(stack_right.pop());
			}else if(command.equals("B")){
				if(!stack_left.isEmpty())
					stack_left.pop();
			}else{
				stack_left.push(st.nextToken().charAt(0));
			}
		}
		String answer ="";
		while(!stack_left.isEmpty()) {
			stack_right.push(stack_left.pop());
		}
		while(!stack_right.isEmpty()) {
			sb.append(stack_right.pop());
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}
