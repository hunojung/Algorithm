// https://leetcode.com/problems/design-hashmap/
class MyHashMap {
    
    List<List<int[]>> map = new ArrayList<>();;

    public MyHashMap() {
        for(int i=0;i<100;i++){
            map.add(new ArrayList<>());
        }
    }
    
    public void put(int key, int value) {
        int mod = key%100;
        List<int[]> curr = map.get(mod);
        for(int[] arr : curr){
            if(arr[0]==key){
                arr[1]=value;
                return;
            }
        }
        
        curr.add(new int[] {key,value});
    }
    
    public int get(int key) {
        int mod = key%100;
        List<int[]> curr = map.get(mod);
        for(int[] arr : curr){
            if(arr[0]==key){
                return arr[1];
            }
        }
        
        return -1;
    }
    
    public void remove(int key) {
        int mod = key%100;
        List<int[]> curr = map.get(mod);
        int[] del = {key,-1};
        for( int[] arr : curr ){
        	if(arr[0]==key) {
                del = arr;
        		break;
        	}
        }
        
        curr.remove(del);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
