// https://leetcode.com/problems/word-ladder/

// first submit
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet(wordList);
        if(!set.contains(endWord))return 0;
        
        int res = 1;
        Set<String> visit = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String now = q.poll();  
                
                if(now.equals(endWord)) return res;
                
                for(int j=0; j<now.length(); j++){
                    char[] chars = now.toCharArray();
                    for(int c = 'a'; c<='z';c++){
                        chars[j] = (char) c;
                        String next = new String(chars);
                        if(set.contains(next) && !visit.contains(next)){
                            q.add(next);
                            visit.add(next);
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }
}
