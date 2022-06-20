// https://leetcode.com/problems/short-encoding-of-words/
class Solution {
    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();
        int answer = 0;
        
        for(String word : words){
            insert(root,word);
        }
        
        Queue<Trie> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Trie now = q.poll();
            int count = 0;
            for(Trie children : now.children){
                if(children == null) continue;
                
                count++;
                q.add(children);
            }
            
            if(count == 0)
                answer += now.len+1;
        }
        
        return answer;
    }
    
    public void insert(Trie root ,String s){
        for(int i=s.length()-1;i>-1;i--){
            char c = s.charAt(i);
            if(root.children[c-'a']==null)
                root.children[c-'a'] = new Trie();
            
            int len = root.len;
            root = root.children[c-'a'];
            root.len = len+1;
        }
    }
}

class Trie{
    Trie[] children;
    int len;
    public Trie(){
        children = new Trie[26];
        len = 0;
    }
}
