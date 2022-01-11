// H-index
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int N = citations.length;
        
        int H = 0;
        for (int i = N; i >= 0; i--) {
			H = i;
        	int countUp = 0;
        	int countDown = 0;
        	for (int j = 0; j < N; j++) {
				if(citations[j]>=H)countUp++;
				if(citations[j]<=H)countDown++;
			}
        	
        	if(countUp>=H && countDown <=H)break;
		}
        return H;
    }
}
