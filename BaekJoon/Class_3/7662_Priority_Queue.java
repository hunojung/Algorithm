// 이중 우선순위 큐
// 통과
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());
		
		while(testcase-->0){

			TreeMap<Integer, Integer> tm = new TreeMap<>();
			
			int N = Integer.parseInt(br.readLine());
			
			while(N-->0){
				StringTokenizer st = new StringTokenizer(br.readLine());
				String order = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				
				// I
				if(order.equals("I")){
					tm.put(number,tm.getOrDefault(number, 0) + 1);
				// D
				}else{
					if(tm.isEmpty())continue;
					// D=1
					if(number==1){
						int max = tm.lastKey();
						if(tm.get(max)==1){
							tm.remove(max);
						}else{
							tm.put(max, tm.get(max)-1);
						}
						
					// D=-1
					}else{
						int min = tm.firstKey();
						if(tm.get(min)==1){
							tm.remove(min);
						}else{
							tm.put(min, tm.get(min)-1);
						}
					}
				}
			}
			
			if(tm.isEmpty()){
				sb.append("EMPTY\n");
			}else{
				sb.append(tm.lastKey()+" "+tm.firstKey()+"\n");
			}
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}

// 시간초과
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(testcase-->0){
			PriorityQueue<Integer> s = new PriorityQueue<>();
			PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
			int N = Integer.parseInt(br.readLine());
			
			while(N-->0){
				StringTokenizer st = new StringTokenizer(br.readLine());
				String order = st.nextToken();
				int number = Integer.parseInt(st.nextToken());
				
				// I
				if(order.equals("I")){
					b.add(number);
					s.add(number);
				
				// D
				}else{
					if(number==1){
						if(!b.isEmpty()){
							int big = b.poll();
							s.remove(big);
						}
					}else{
						if(!s.isEmpty()){
							int small = s.poll();
							b.remove(small);
						}
					}
				}
			}
			
			if(s.isEmpty()){
				sb.append("EMPTY").append("\n");
			}else{
				sb.append(b.poll()).append(" ").append(s.poll()).append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}
// 7662 END
