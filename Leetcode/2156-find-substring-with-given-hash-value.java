// https://leetcode.com/problems/find-substring-with-given-hash-value/

// retry
class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        String answer ="";
    	long hash = 0, mul = 1, sub;
        
        for (int i = s.length()-1; i > s.length()-k; i--) {
			sub = s.charAt(i)-'a'+1;
			
			hash *= power;
			hash += sub;
			hash %= modulo;
			
			mul *= power;
			mul %= modulo;
		}
        
    	for (int i = s.length()-k; i > -1; i--) {
    		sub = s.charAt(i)-'a'+1;
    		
    		hash *= power;
    		hash += sub;
    		if(hash>=modulo)
    			hash%=modulo;
    		
    		if(hash==hashValue)
    			answer = s.substring(i, i+k);
    		
    		sub = s.charAt(i+k-1)-'a'+1;
    		sub *= mul;
    		sub %= modulo;
    		
    		// 그냥 sub만 빼면 음수가 될 수도 있어서?
    		hash += modulo - sub;
    		hash %= modulo;
    	}
    	
    	return answer;
    }
}

// fitst submit code
public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
    String answer = "";
    long[] multi = new long[k+1];
    multi[0]=1;
    power=power%modulo;
    for (int i = 1; i < k+1; i++) {
      multi[i]=(multi[i-1]*power)%modulo;
    }

    for (int i = 0; i < s.length()-(k-1); i++) {
    String sub = s.substring(i,i+k);
    long sum = 0;
    for (int j = 0; j < k; j++) {
      int next = (sub.charAt(j)-'a'+1);
      sum+=next*multi[j];
    }
    if(sum%modulo==hashValue){
      answer=sub;
      break;
    }
  }
  return answer;
}
