// https://leetcode.com/problems/detect-capital/

// updated code
class Solution {
    public boolean detectCapitalUse(String word) {
        boolean answer = false;
        boolean upper = true;
        boolean lower = true;
        boolean firstCap = false;
    	int len = word.length();
    	
    	// 1글자면 true
    	if(len<2){
    		answer = true;
    		
    	// 2글자 이상
    	}else{
    		for (int i = 0; i < len; i++) {
    			if(i==0){
    				if(word.charAt(0)>='A'&&word.charAt(0)<='Z')
    					firstCap=true;
    			}else{
    				
    				// 올 대문자, 소문자랑 같으면 true
    				if(word.charAt(i)>='A'&&word.charAt(i)<='Z'){
    					lower=false;    					
    				}else{
    					upper=false;
    				}	
    			}
			}
    		
    		// 대문자 true, 소문자 ture, 대문자 false
    		if(firstCap&&lower&&!upper){
    			answer=true;
    		// 대문자 true, 소문자 false, 대문자 true
    		}else if(firstCap&&!lower&&upper){
    			answer=true;
    		// 대문자 false, 소문자 true, 대문자 false;
    		}else if(!firstCap&&lower&&!upper){
    			answer=true;
    		}
    	}
    	return answer;
    }
}

// first submit code
class Solution {
public boolean detectCapitalUse(String word) {
        boolean answer = false;
    	int len = word.length();
    	
    	// 1글자면 true
    	if(len<2){
    		answer = true;
    		
    	// 2글자 이상
    	}else{
    		String upper = word.toUpperCase();
    		String lower = word.toLowerCase();
    		//System.out.println(upper+" "+lower);
    		
    		// 올 대문자, 소문자랑 같으면 true
    		if(word.equals(upper) || word.equals(lower)){
    			answer=true;
    			
    		// 올 대문자, 소문자 아닐경우
    		}else{
    			
    			// 첫글자 대문자 && 나머지 소문자
    			char first = word.charAt(0);
    			if(first >='A' && first<'Z' && word.substring(1,len).equals(lower.substring(1,len))){
    				answer = true;
    			}
    		}
    	}
    	return answer;
    }
}
