// https://leetcode.com/problems/search-suggestions-system/
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> answer = new ArrayList<>();
        Arrays.sort(products);
        
        Trie root = new Trie();
        for(int i = 0; i<products.length;i++){
            insert(root,products[i]);
        }
        
        for(char c : searchWord.toCharArray()){
            root = root.children[c-'a'];
            if(root == null) break;
            
            answer.add(root.list);
        }
        
        while(answer.size()<searchWord.length())
            answer.add(new ArrayList<>());
        
        return answer;
    }
    
    public void insert(Trie root, String word){
        for(char c : word.toCharArray()){
            if(root.children[c-'a']==null)
                root.children[c-'a'] = new Trie();
            root = root.children[c-'a'];
            if(root.list.size()<3) root.list.add(word);
        }
    }
}

class Trie{
    public Trie[] children;
    public List<String> list;
    
    public Trie(){
        children = new Trie[26];
        list = new ArrayList<>();;
    }
}
