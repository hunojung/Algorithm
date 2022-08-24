// https://school.programmers.co.kr/learn/courses/30/lessons/84512
import java.util.*;
class Solution {
    public int solution(String word) {
        Map<Character,Integer> char_to_int = new HashMap<>();
        char_to_int.put('A',1);
        char_to_int.put('E',2);
        char_to_int.put('I',3);
        char_to_int.put('O',4);
        char_to_int.put('U',5);
        
        int answer = 0;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            for(int j=0;j<(5-i);j++){
                answer += (char_to_int.get(c)-1)*Math.pow(5,j);
            }
            answer += 1;
        }

        return answer;
    }
}


import java.util.*;
class Solution {
    Map<Integer,Integer> seq_map = new HashMap<>();
    public int solution(String word) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',1);
        map.put('E',2);
        map.put('I',3);
        map.put('O',4);
        map.put('U',5);
        dfs(1,1);

        int convert_char_to_int = 0;
        for(char c : word.toCharArray()){

            convert_char_to_int = (convert_char_to_int*10)+map.get(c);

        }
        return seq_map.get(convert_char_to_int);
    }

    public void dfs(int word, int seq){
        seq_map.put(word,seq);

        if(word>=55555) return;

        if(word<10000){
            word = (word*10)+1;
            dfs(word,seq+1);
        }else if(word%10 < 5){
            word = word+1;
            dfs(word,seq+1);
        }else{
            while(word%10==5){
                word/=10;
            }
            word+=1;
            dfs(word,seq+1);
        }
    }
}
