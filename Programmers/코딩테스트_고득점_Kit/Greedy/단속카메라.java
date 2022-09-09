import java.util.*;
// [[10, 20], [10, 11], [12, 13], [14, 15]] -> 3
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes,(a,b)->a[0]-b[0]);
        
        // for(int[] route:routes) System.out.println(route[0]+" "+route[1]);
        int idx = 0;
        while(idx<routes.length){
            int camera =  routes[idx++][1];
            answer++;
            while(idx<routes.length && camera >= routes[idx][0]){
                camera = Math.min(camera,routes[idx][1]);
                idx++;
            }
        }
        return answer;
    }
}
