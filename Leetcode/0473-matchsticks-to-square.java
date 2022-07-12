// https://leetcode.com/problems/matchsticks-to-square/
class Solution {
    public boolean makesquare(int[] matchsticks) {
        
        int sum = Arrays.stream(matchsticks).sum();
        if(sum%4!=0) return false;
        
        Arrays.sort(matchsticks);
        
        return dfs(matchsticks, new int[4], matchsticks.length-1,sum/4);
    }
    
    private boolean dfs(int[] matchsticks, int[] face, int idx, int target){
        
        if(idx == -1){
            if(face[0]==target && face[1]==target && face[2]==target && face[3]==target)
                return true;
            
            return false;
        }
        
        for(int i=0;i<4;i++){
            // 직전꺼에서 false니까 i가 넘어온건데 같으면 걍 넘김
            if(face[i]+matchsticks[idx]>target  || (i>0 && face[i] == face[i-1])) continue;
            
            face[i]+=matchsticks[idx];
            
            if(dfs(matchsticks, face, idx-1, target) == true)
                return true;
            
            face[i]-=matchsticks[idx];
        }
        
        return false;
    }
}
