// https://school.programmers.co.kr/learn/courses/30/lessons/43164
import java.util.*;
class Solution {
    
    public String[][] tickets;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        String[] answer = new String[tickets.length+1];
        answer[0] = "ICN";
        
        Arrays.sort(tickets,(a,b)->a[0].equals(b[0])?a[1].compareTo(b[1]):a[0].compareTo(b[0]));
        
        dfs(new boolean[tickets.length],answer,1);
        
        return answer;
    }
    
    public boolean dfs(boolean[] visited, String[] answer,int idx){
        if(idx == answer.length) return true;
        
        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(answer[idx-1])){

                visited[i] = true;
                answer[idx] = tickets[i][1];
                
                if(dfs(visited,answer,idx+1)) return true;

                visited[i] = false;

            }
        }
        return false;
    }
}




import java.util.*;
class Solution {
    public String[] solution(String[][] tickets) {
        Map<String,List<String>> map = new HashMap<>();
        for(String[] ticket : tickets){
            
            if(map.containsKey(ticket[0])){
                List<String> list = map.get(ticket[0]);
                list.add(ticket[1]);
                Collections.sort(list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(ticket[1]);
                map.put(ticket[0],list);
                Collections.sort(list);
            }
        }
        
        String[] answer = new String[tickets.length+1];
        answer[0] = "ICN";
        
        dfs(answer,1,map);
        
        return answer;
    }
    
    public boolean dfs(String[] answer,int idx, Map<String,List<String>> map){
        if(idx == answer.length) return true;
        
        if(!map.containsKey(answer[idx-1]) || map.get(answer[idx-1]).isEmpty()) return false;
        
        List<String> list = map.get(answer[idx-1]);
        int size = list.size();
        for(int i=0;i<size;i++){
            
            answer[idx] = list.get(i);
            list.remove(i);
            if(dfs(answer,idx+1,map)) return true;
            
            list.add(answer[idx]);
            Collections.sort(list);
        }
        
        return false;
    }
}


