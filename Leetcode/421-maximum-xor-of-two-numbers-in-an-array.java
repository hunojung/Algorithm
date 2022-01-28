// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
public class Solution{
	
	static Trie root;
    public int findMaximumXOR(int[] nums) {
    	root = new Trie();
    	
    	int max = 0;
    	for(int num : nums)
    		insert_bits(num);
    	
        for (int num : nums){
        	max = Math.max(max,find(num));
        }
        return max;
    }
    
    static int find(int num){
    	Trie node = root;
    	int bitIdx = 31;
    	int ans = 0;
    	
    	while(bitIdx>=0){
    		int mask = 1<<bitIdx;
    		int bitValue = (mask&num)==0?0:1;
    		int oppo_bitValue = bitValue^1; // bitValue가 0이면1 - 1이면 0
    		
    		if(oppo_bitValue==0){
    			if(node.zero!=null){
    				ans+=mask;
    				node = node.zero;
    			}else{
    				node = node.one;
    			}
    		}else{
    			if(node.one!=null){
    				ans+=mask;
    				node = node.one;
    			}else{
    				node = node.zero;
    			}
    		}
    		bitIdx--;    		
    	}
    	return ans;
    }
    
    static void insert_bits(int num){
    	Trie node = root;
    	int bitIdx = 31;
    	
    	while(bitIdx>=0){
    		int mask = 1<<bitIdx;
    		int bitValue = (mask&num)==0?0:1;
    		if(bitValue==1){
    			if(node.one==null)
    				node.one = new Trie();
    			node = node.one;
    		}else{
    			if(node.zero==null)
    				node.zero = new Trie();
    			node = node.zero;
    		}
    		bitIdx--;
    	}
    }
    
    static class Trie {
        Trie zero;
        Trie one;
        
        public Trie() {
        	this.zero = null;
        	this.one = null;
        }
    }
}
