// https://leetcode.com/problems/combination-sum-iii/
class Solution {
    private List<List<Integer>> answer;
    public List<List<Integer>> combinationSum3(int k, int n) {
        answer = new ArrayList<>();
        backTracking(k,n,new ArrayList<>(),1,0);
        return answer;
    }
    
    private void backTracking(int k,int n,List<Integer> list,int start,int sum){
        if(sum>n) return;
        
        if(list.size()==k){
            if(sum==n){
                answer.add(new ArrayList(list));
            }
            
            return;
        }
        
        for(int i=start ; i<10; i++){
            list.add(i);
            backTracking(k,n,list,i+1,sum+i);
            list.remove(list.size()-1);
        }
    }
}
