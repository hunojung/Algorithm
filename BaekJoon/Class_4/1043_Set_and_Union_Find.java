// https://www.acmicpc.net/problem/1043
// 거짓말
// Union_Find
import java.io.*;
import java.util.*;

public class Main{
	static int[] parent;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> hearPeople = new HashSet<>();
		
		// 본 사람 넣기
		st = new StringTokenizer(br.readLine());
		int people =Integer.parseInt(st.nextToken());
		for (int i = 0; i < people; i++) {
			hearPeople.add(Integer.parseInt(st.nextToken()));
		}
		
		HashSet<Integer>[] party = new HashSet[M+1];
		parent = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			parent[i]=i;			
		}
		
		for (int i = 1; i < M+1; i++) {
			party[i] = new HashSet<>();
		}
		
		for (int i = 1; i < M+1; i++) {
			st = new StringTokenizer(br.readLine());
			int party_num = Integer.parseInt(st.nextToken());
			
			int a = Integer.parseInt(st.nextToken());
			party[i].add(a);

			if(party_num==1){
				continue;
			}
			
			for (int j = 1; j < party_num; j++) {
				int b = Integer.parseInt(st.nextToken());
				if(find(a) != find(b)){
					union(a,b);
				}
				
				//파티 참여하는 사람 저장
				party[i].add(b);
			}
		}
			
		for (int i = 1; i < N+1; i++) {
			if(hearPeople.contains(i)){
				int root = find(i);
				for (int j = 1; j < N+1; j++) {
					if(find(j)==root){
						hearPeople.add(j);
					}
				}
			}		
		}
		
		// 모든 파티 참석자가 F면 얘기 가능
		int result = 0;
		for (int i = 1; i < M+1; i++) {
			boolean flag = false;
			for(Integer person : party[i]){
				if(hearPeople.contains(person)){
					flag = true ;
					break;
				}
			}
			if(!flag) result++;
		}
		System.out.println(result);
	}
	
	public static int find(int idx){
		if(parent[idx]==idx){
			return idx;
		}
		parent[idx] = find(parent[idx]);
		return parent[idx];
	}
	
	public static void union(int a, int b){
		int parent_b = find(b);
		parent[parent_b]=a; // b의 parent를 a로 변경
	}
}
// END Union_Find

// Set
import java.io.*;
import java.util.*;

public class Main{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashSet<Integer> hearPeople = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		int people =Integer.parseInt(st.nextToken());
		
		// 본 사람 넣기
		for (int i = 0; i < people; i++) {
			hearPeople.add(Integer.parseInt(st.nextToken()));
		}
		
		HashSet<Integer>[] party = new HashSet[M];
		
		// Set 에 파티,사람 넣기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int partyPeople = Integer.parseInt(st.nextToken());
			party[i] = new HashSet<>();
			for (int j = 0; j < partyPeople; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int endCount = M;
		boolean add = false;
        
        // hearPeople에 들을 가능성 있는 사람 모두 추가 될 때 까지
		while(endCount>0){
			endCount = M;
			
			for (int i = 0; i < M; i++) {
				add = false;
				HashSet<Integer> HP = (HashSet<Integer>) hearPeople.clone();
				for(Integer h : HP){
					if(party[i].contains(h)){
						for (Integer p : party[i]) {
							if(!hearPeople.contains(p)){
								hearPeople.add(p);
								add=true;
							}
						}
					}
				}
				if(!add)endCount--;
			}
		}
		
        //파티에 참가할 수 있나?
		int answer = M;
		for (int i = 0; i < M; i++) {
			add = false;
			for(Integer h : hearPeople){
				if(party[i].contains(h)){
					answer--;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}
// END Set
