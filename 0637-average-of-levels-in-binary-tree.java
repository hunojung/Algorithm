// https://leetcode.com/problems/average-of-levels-in-binary-tree/
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            double sum = 0;
            for(int i = 0; i<size;i++){
                TreeNode now = q.poll();
                sum += now.val;
                
                if(now.left != null) q.add(now.left);
                if(now.right != null) q.add(now.right);
            }
            
            answer.add(sum/size);
        }
        return answer;
    }
}
