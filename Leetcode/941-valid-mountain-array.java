// https://leetcode.com/problems/valid-mountain-array/
// first submit code
import java.io.*;
import java.util.*;

public class Solution{
	
    public boolean validMountainArray(int[] arr) {
        int len = arr.length;
        
        // 길이 짧으면 return
        if(len<3)return false;
        
        int start = arr[0];
        int turn = 0;
        int inc = 0;
        int before_inc=arr[1]-arr[0];
        
        // 첨부터 경사 안지면 return
        if(before_inc<=0)return false;
        
        for (int i = 2; i < len; i++) {
        	inc = arr[i]-arr[i-1];
        	
        	// 증가량이 다르다
        	if(inc != before_inc){
        		// 꼭대기 꺽임
        		if(inc < 0 && before_inc>0){
        			
        		// 오르막길 유지
        		}else if(inc > 0 && before_inc > 0){
        			
        		// 내리막길 유지
        		}else if(inc < 0 && before_inc < 0){
        			
        		}else{
        			return false;
        		}
        	}
        	
        	before_inc = inc;
		}
        
        // 마지막까지 내리막길 없었으면 false;
        if(inc>0)return false;
    	return true;
    }
}
