// DSLR
// 9019
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	
	static boolean[] ok; 
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());		
			int B = Integer.parseInt(st.nextToken());
			ok = new boolean[10000];
			sb.append(bfs(A,B)).append("\n");

//			// S
//			int a = A>0?A-1:9999;
//
//			
//			// L
//			int L = (A*10)%10000+(A/1000)%10;
//
//			
//			// R
//			int R = (A%10)*1000+A/10;
//			
//			System.out.println(a+" "+L+" "+R);

		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
	
	
	public static String bfs(int A , int B){
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int[] comp = new int[4];
		
		list.add(B/1000);
		list.add((B/100)%10);
		list.add((B/10)%10);
		list.add(B%10);
		
		int next = 0;
		int number = 0;
		String order = "";// 숫자,명령,숫자,명령 순서로 큐에 입력
		Queue<String> q = new LinkedList<>();
		q.add(Integer.toString(A));
		q.add(order);
		ok[A]=true;
		while(!q.isEmpty()){
			next = Integer.parseInt(q.poll());
			order = q.poll();
			
			comp[0] = next/1000;
			comp[1] = (next/100)%10;
			comp[2] = (next/10)%10;
			comp[3] = next%10;
			boolean contain = true;
			
			for (int i = 0; i < 4; i++) {
				if(!list.contains(comp[i]))contain=false;
			}
			
			//System.out.println(next+" "+order+" ");
			if(next==B)break;
			// D
			number = (next*2)%10000;
			if(!ok[number]){				
				ok[number]=true;
				q.add(Integer.toString(number));
				q.add(order+"D");
			}
			
			// S
			number = next>0?next-1:9999;
			if(!ok[number]){			
				ok[number]=true;
				q.add(Integer.toString(number));
				q.add(order+"S");
			}
			
			// L
			int L = (next*10)%10000+(next/1000);
			if(!ok[L]){
				ok[L]=true;
				q.add(Integer.toString(L));
				q.add(order+"L");
			}
			
			// R
			int R = (next%10)*1000+next/10;
			if(!ok[R]){
				ok[R]=true;
				q.add(Integer.toString(R));
				q.add(order+"R");
			}
			
			//System.out.print((next*2)%10000+" "+(next>0?next-1:9999)+" "+L+" "+R+"\n");
			
		}
		
		return order;
	}
}
// 9019 END
