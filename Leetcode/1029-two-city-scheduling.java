// https://leetcode.com/problems/two-city-scheduling/
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length/2;
        int sum = 0;
        
        // all A sum
        for(int i=0;i<2*n;i++)
            sum+=costs[i][0];
        
        // sort A-B
        Arrays.sort(costs,new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return (o2[0]-o2[1])-(o1[0]-o1[1]);
        	}
		});
        
        // sum-a+b
        for(int i=0;i<n;i++){
            sum+=(costs[i][1]-costs[i][0]);
        }
        
        return sum;
    }
}
