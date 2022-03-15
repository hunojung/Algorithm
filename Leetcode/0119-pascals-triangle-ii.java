// https://leetcode.com/problems/pascals-triangle-ii/
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        for(int i=1;i<rowIndex+1;i++){
            List<Integer> add = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j==0)
                    add.add(answer.get(0));
                else if(j==i)
                    add.add(answer.get(j-1));
                else
                    add.add(answer.get(j-1)+answer.get(j));
            }
            answer = new ArrayList(add);
        }
        return answer;
    }
}
