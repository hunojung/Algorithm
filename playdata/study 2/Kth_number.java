// K 번째 수
import java.util.Arrays;

public class Solution {
public int[] solution(int[] array, int[][] commands) {
    	int N = commands.length;
        int[] answer = new int[N];
        
        
        for (int i = 0; i < N; i++) {
        	int start = commands[i][0]-1;
        	int end = commands[i][1]-1;
        	int index = commands[i][2]-1;
        	//System.out.println(start+" "+end+" "+index);
        	
        	int[] copy = new int[end-start+1];
        	
        	for (int j = 0; j < end-start+1; j++) {
				copy[j] = array[j+start];
			}
        	Arrays.sort(copy);
			answer[i]=copy[index];
			//System.out.println(answer[i]);
		}
        
        return answer;
    }
}
