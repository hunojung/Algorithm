// https://programmers.co.kr/learn/courses/30/lessons/42895
// N으로 표현
import java.util.*;

public class Solution{
    public int solution(int N, int number) {
        Set<Integer>[] setN = new Set[9];
        
        int n = N;
        for (int i = 1; i < 9; i++) {
			setN[i] = new HashSet<>();
			setN[i].add(n);
			n = n*10+N;
		}

        // 단순 이전 갯수일 때 +N, -N, /N , *N 하는게아니라
        // 7개면 3개일때 4개일때 +,-,*,/ 를 하면 7개를 한것이 되는것이다
        for (int i = 1; i < 9; i++) {
        	for (int j = 1; j < i; j++) {
        		for (Integer a : setN[j]) {
        			for (Integer b : setN[i-j]) {
        				setN[i].add(a+b);
        				setN[i].add(a-b);
        				setN[i].add(b-a);
        				setN[i].add(a*b);
        				if(b!=0)setN[i].add(a/b);
        				if(a!=0)setN[i].add(b/a);
        			}
				}
        	}
            if(setN[i].contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}
