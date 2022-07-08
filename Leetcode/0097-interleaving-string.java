// https://leetcode.com/problems/interleaving-string/
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        
        
        Boolean[][] visited = new Boolean[s1.length()+1][s2.length()+1];
        return dfs(s1,s2,s3,visited,0,0);
    }
    
    public boolean dfs(String s1, String s2, String s3, Boolean[][] visited , int i,int j){
        if(i+j == s3.length()) return true;
        
        if(visited[i][j]!=null)
            return visited[i][j];
        
        if(s1.length() > i && s3.charAt(i+j)==s1.charAt(i)){
            visited[i][j] = dfs(s1,s2,s3,visited,i+1,j);
            if(visited[i][j])
                return true;
        }
        
        if(s2.length() > j && s3.charAt(i+j)==s2.charAt(j)){
            visited[i][j] = dfs(s1,s2,s3,visited,i,j+1);
            if(visited[i][j])
                return true;
        }
        
        return visited[i][j]=false;
    }
}
