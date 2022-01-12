// 카페트
class Solution {
    // yellow = xy
	// brown = 2(x+y+2)
	// brown 기준 y = brown/2 -2 -x;
	// yellow = x * (brown/2)-2x - x*x;
	public int[] solution(int brown, int yellow) {
    	int[] answer = new int[2];
        
        int x = 1;
        int y = 0;
        while(true){
        	y = (brown/2)-2-x;
        	
        	if(x*y == yellow)break;
        	else x++;
        }
        
        answer[1]=x+2;
        answer[0]=y+2;
        //System.out.println(answer[0]+" "+answer[1]);
        return answer;
    }
}
