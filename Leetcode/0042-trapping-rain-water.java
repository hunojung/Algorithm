// https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int l = 0, r = height.length-1;
        int lmax = 0, rmax = 0;
        
        while(l<=r){
            lmax = Math.max(lmax,height[l]);
            rmax = Math.max(rmax,height[r]);
            
            if(lmax < rmax){
                answer += lmax-height[l];
                l++;
            }else{
                answer += rmax-height[r];
                r--;
            }
        }
        
        return answer;
        
    }
}

// first submit
class Solution {
    public int trap(int[] height) {
        if( height.length<3) return 0;
        int answer = 0;
        int l = 0, r = 1;
        int sum = 0;
        
        int max_height_idx = 0;
        int max_height = 0;
        while(l < height.length && r < height.length){
            
            if(height[l] > height[r]){
                sum += height[l]-height[r];
                
                if(max_height<height[r]){
                    max_height = height[r];
                    max_height_idx = r;
                }
                
                r++;
            }else{
                answer += sum;
                sum = 0;
                l=r;
                if(l>=height.length-1) break;
                
                r=l+1;
                max_height_idx = r;
                max_height = height[max_height_idx];
            }
            
            if( r>= height.length ){
                for(int i=max_height_idx;i<height.length;i++) sum -= (height[l]-height[i]);
                
                answer += (sum - (max_height_idx-l-1)*(height[l]-max_height));
                sum = 0;
                
                l = max_height_idx;
                if(l>=height.length-1) break;
                r=l+1;
                max_height_idx = r;
                max_height = height[max_height_idx];
            }
        }
        return answer;
        
    }
}
