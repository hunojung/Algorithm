// https://leetcode.com/problems/my-calendar-i/
class MyCalendar {
   class TreeNode{
       int start;
       int end;
       TreeNode left;
       TreeNode right;
       public TreeNode(int start, int end){
           this.start = start;
           this.end = end;
       }
   }
    
    TreeNode root;
    public MyCalendar() {
    }
    
    public boolean book(int start, int end) {
        if(root == null){
            root = new TreeNode(start,end);
            return true;
        }
        
        TreeNode dummy = root;
        while(dummy != null){
            if(dummy.start >= end){
                if(dummy.left == null){
                    dummy.left = new TreeNode(start,end);
                    return true;
                }
                dummy = dummy.left;
            }else if(dummy.end <= start){
                if(dummy.right == null){
                    dummy.right = new TreeNode(start,end);
                    return true;
                }
                dummy = dummy.right;
            }else{
                break;
            }
        }
        return false;
    }
}

// first submit
class MyCalendar {

    List<int[]> booked;
    public MyCalendar() {
        booked = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int i = 0; i < booked.size() ; i++){
            int[] check = booked.get(i);
            if(start < check[1] && check[0]< end ){
                return false;
            }
        }
        booked.add(new int[] {start,end});
        return true;
    }
}
