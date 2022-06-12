//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0, r=numbers.length-1;
        
        while(l<r){
            
            int m = (l-r)/2+r;
            int sum = numbers[l]+numbers[r];
            
            if(sum==target){
                break;
            }else if(sum>target){
                if(numbers[l]+numbers[m]>target){
                    r = m-1;
                }else{
                    r--;
                }
            }else{
                
                if(numbers[m]+numbers[r]<target){
                    l = m+1;
                }else{
                    l++;
                }
            }
        }
        
        return new int[] {l+1,r+1};
    }
}

// 0401 submit
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0,r=numbers.length-1;
        int[] res = new int[2];
        while(l<r){
            int sum = numbers[l]+numbers[r];
            if(sum==target){
                res[0]=l+1;
                res[1]=r+1;
                break;
            }else if(sum<target){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
