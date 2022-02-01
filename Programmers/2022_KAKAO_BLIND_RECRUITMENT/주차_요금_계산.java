// https://programmers.co.kr/learn/courses/30/lessons/92341
import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String,Integer> parking = new HashMap<>();
        // 자동으로 자동차 번호 순 정렬
        TreeMap<String,Integer> result = new TreeMap<>();
        
        for(String s : records){
            String[] record = s.split(" ");
            String[] times = record[0].split(":");
            int time = Integer.parseInt(times[0])*60+Integer.parseInt(times[1]);
            
            // IN
            if(record[2].equals("IN")){
                parking.put(record[1],time);
            
            // OUT
            }else{
                
                // 누적 시간
                int time_out = (time-parking.remove(record[1]));

                // 누적시간 저장
                result.put(record[1],result.getOrDefault(record[1],0)+time_out);
            }
        }
        
        // 23:59 남아있는차
        int lastTime = 23*60+59;
        for(String s : parking.keySet()){
            
            int time = (lastTime-parking.get(s));
            result.put(s,result.getOrDefault(s,0)+time);
        }
        
        // 누적시간 계산 후 입력
        int index =0;
        int[] answer = new int[result.size()];
        
        for(String s : result.keySet()){
            int fee = fees[1];
            int time = result.get(s)-fees[0];
            if(time>0){
                fee+=(time/fees[2])*fees[3];
                if(time%fees[2]!=0)fee+=fees[3];
            }
            answer[index]=fee;
            index++;
        }
        return answer;
    }
}
