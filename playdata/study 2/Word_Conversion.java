// 단어 변환
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	// 다른 단어가 1개인지 확인한다.
	static boolean ok_q(String begin, String target){
		
		int count = 0;
		if(begin.length() == target.length()){
		
			for (int i = 0; i < begin.length(); i++) {
				if(begin.charAt(i) != target.charAt(i))count++;
			}
		}
		
		if(count==1)return true;
		return false;
	}
	
	
    public int solution(String begin, String target, String[] words) {
        int ans = 0;
        int size = words.length;
          boolean[] ok = new boolean[size];

        Queue<String> q = new LinkedList<>();

        q.add(begin);
        q.add(Integer.toString(0));

        while(!q.isEmpty()){
          String next = q.poll();
          int depth = Integer.parseInt(q.poll());

          if(next.equals(target)){
            ans = depth;
            break;
          }
          for (int i = 0; i < size; i++) {
          if(ok_q(next,words[i]) && !ok[i]){
            q.add(words[i]);
              q.add(Integer.toString(depth+1));
              ok[i]=true;
          }
        }
    	}
        return ans;
    }
}
