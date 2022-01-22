// https://programmers.co.kr/learn/courses/30/lessons/92334
// 신고 결과 받기

// 분류
// 자료구조
import java.io.*;
import java.util.*;

public class Solution{
	
    public int[] solution(String[] id_list, String[] report, int k) {
        int id_len = id_list.length;
        int[] answer = new int[id_len];
        int report_len = report.length;
        int[] reportCount =new int[id_len];
        
        // map에 id와 index번호 넣기
        Map<String,Integer> id = new HashMap<>();
        for (int i = 0; i < id_len; i++) {
			id.put(id_list[i],i);
		}
        
        Set<String>[] list = new HashSet[id_len];
        for (int i = 0; i < id_len; i++) {
			list[i]= new HashSet<>();
		}
        
        // report 당하면 reportCount[당한사람인덱스]++;
        for (int i = 0; i < report_len; i++) {
			StringTokenizer st = new StringTokenizer(report[i]);
			String a = st.nextToken();
			String b = st.nextToken();
            
            // a가 b를 여러번 신고못하게
			if(!list[id.get(a)].contains(b)){
				reportCount[id.get(b)]++;
				list[id.get(a)].add(b);				
			}
		}
        
        // 신고당한 사람 훑어보기
        for (int i = 0; i < id_len; i++) {
			if(reportCount[i]>=k){
				
				// 신고 한사람 메세지 ++;
				for (int j = 0; j < id_len; j++) {
					if(list[j].contains(id_list[i])){
						answer[j]++;
					}
				}
			}
		}
        
        return answer;
    }
}
