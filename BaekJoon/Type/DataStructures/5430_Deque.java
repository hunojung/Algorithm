// https://www.acmicpc.net/problem/5430
// AC

// 분류
// 구현
// 자료 구조
// 문자열
// 파싱
// 덱
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(testcase-->0){
			String s = br.readLine();
			
			// RR 두번은 원상복귀니까 삭제
			// 이거안하면 시간초과
			s.replace("RR",	"");
			int N = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(),"[,]");
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean flip = false;
			boolean err = false;
			for (int i = 0; i < s.length(); i++) {
				
				// 뒤집기
				if(s.charAt(i)=='R'){
					flip = !flip;
					
				// 맨앞 삭제하기
				}else{
					
					//비었는데 삭제인건 error
					if(list.isEmpty()){
						err = true;
						break;
					
					// 삭제
					}else{
						if(flip){
							list.remove(list.size()-1);
						}else{
							list.remove(0);
						}
					}
				}
			}
			if(err){
				sb.append("error").append("\n");
			}else{
				sb.append("[");
				int len = list.size();
				if(flip){
					for (int i = len-1; i > -1; i--) {
						if(i<len-1)sb.append(",");
						
						sb.append(list.get(i));
					}
				}else{
					for (int i = 0; i < len; i++) {
						if(i>0)sb.append(",");
						
						sb.append(Integer.toString(list.get(i)));
					}
				}
				sb.append("]").append("\n");
			}
		}
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}
