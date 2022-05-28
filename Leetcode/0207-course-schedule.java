// https://leetcode.com/problems/course-schedule/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        
        for(int[] n : prerequisites){
            list.get(n[1]).add(n[0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                boolean[] cycleVisited = new boolean[numCourses];
                if(isCyclic(list,i,visited,cycleVisited)) return false;
            }
        }
        
        return true;
    }
    
    private boolean isCyclic(List<List<Integer>> list, int num, boolean[] visited,boolean[] cycleVisited){
        visited[num]=true;
        cycleVisited[num]=true;
        
        for(int i:list.get(num)){
            if(cycleVisited[i])
                return true;
            
            if(!visited[i] && isCyclic(list,i,visited,cycleVisited))
                return true;
        }
        
        cycleVisited[num]=false;
        return false;
    }
}
