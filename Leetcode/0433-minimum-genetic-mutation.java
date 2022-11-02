// https://leetcode.com/problems/minimum-genetic-mutation/
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        
        Queue<String> q = new LinkedList<>();
        boolean[] used = new boolean[bank.length];
        q.add(start);
        
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String now = q.poll();
                
                if(now.equals(end)){
                    return count;
                }
                
                for(int j=0;j<bank.length;j++){
                    if(!used[j] && check_mutation(now,bank[j])){
                        used[j] = true;
                        q.add(bank[j]);
                    }
                }
            }
            
            count++;
        }
        
        return -1;
    }
    
    private boolean check_mutation(String start, String end){
        int count = 0;
        for(int i=0;i<8;i++){
            if(start.charAt(i)!=end.charAt(i)){
                count++;
            }
        }
        
        return count == 1;
    }
}
