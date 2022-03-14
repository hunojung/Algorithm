// https://leetcode.com/problems/pascals-triangle/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> added = new ArrayList<>();
        added.add(1);
        answer.add(new ArrayList(added));
        for(int i=1;i<numRows;i++){
            List<Integer> add = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j==0)
                    add.add(added.get(0));
                else if(j==i)
                    add.add(added.get(j-1));
                else
                    add.add(added.get(j-1)+added.get(j));
            }
            answer.add(new ArrayList(add));
            added = new ArrayList(add);
        }
        return answer;
    }
}
