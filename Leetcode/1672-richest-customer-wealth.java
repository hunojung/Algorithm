// https://leetcode.com/problems/richest-customer-wealth/
class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
    	for(int i=0; i<accounts.length;i++){
        	max = Math.max(max, Arrays.stream(accounts[i]).sum());
        }
    	return max;
    }
}
