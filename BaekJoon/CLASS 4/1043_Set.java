// https://www.acmicpc.net/problem/1043
// 거짓말
import java.io.*;
import java.util.*;

import javax.net.ssl.HandshakeCompletedEvent;

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
