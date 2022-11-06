// https://leetcode.com/problems/word-search-ii/

class Solution {
    private static final char HASH_TAG = '#';
    private Node root = new Node();
    
    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words){
            Node tmp = root;
            
            for(int i = word.length()-1 ; i >= 0; i--){
                int idx = word.charAt(i)-'a';
                if(tmp.val[idx] == null){
                    tmp.val[idx] = new Node();
                    tmp.val[idx].parent = tmp;
                    tmp.val[idx].idx = idx;
                }
                tmp = tmp.val[idx];
            }
            tmp.word = word;
        }
        
        return searchWord(board);
    }
    
    private List<String> searchWord(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                checkWord(res,i,j,board,root);
            }
        }
        return res;
    }
    
    private void checkWord(List<String> res,int n,int m,char[][] board,Node tmp){
        if(n>=board.length || n<0 || m >= board[0].length || m<0  )
            return;
        
        char ch = board[n][m];
        if(ch == HASH_TAG || tmp.val[ch-'a'] == null)
            return;
        
        tmp = tmp.val[ch-'a'];
        
        if(tmp.word != null){
            res.add(tmp.word);
            tmp.word = null;
            
            Node ptr = tmp;
            while(ptr.parent != null && ptr.isEmpty()){
                int idx = ptr.idx;
                ptr = ptr.parent;
                ptr.val[idx] = null;
            }
        }
        
        board[n][m] = HASH_TAG;
        
        checkWord(res,n-1,m,board,tmp);
        checkWord(res,n+1,m,board,tmp);
        checkWord(res,n,m-1,board,tmp);
        checkWord(res,n,m+1,board,tmp);
        
        board[n][m] = ch;
    }
}

class Node{
    Node parent;
    Node[] val = new Node[26];
    String word;
    int idx;
    
    public boolean isEmpty(){
        for(int i=0;i<26;i++){
            if(val[i] != null){
                return false;
            }
        }
        return true;
    }
}

