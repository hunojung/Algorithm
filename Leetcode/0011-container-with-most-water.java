// https://leetcode.com/problems/container-with-most-water/
class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int water = Math.min(height[l],height[r])*(r-l);
        while(l<r){
            if(height[r]<height[l]){
                int rh = height[r];
                while(l<r && rh>=height[r])
                    r--;
            }else{
                int lh = height[l];
                while(l<r && lh>=height[l])
                    l++;
            }
            water = Math.max(water,Math.min(height[l],height[r])*(r-l));
        }
        return water;
    }
}
