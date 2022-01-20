// https://programmers.co.kr/learn/courses/30/lessons/43105
// 정수 삼각형
class Solution {
public int solution(int[][] triangle) {
        int N = triangle.length;
        int[][] ansTri = new int[N][N];
    	int answer = 0;
    	ansTri[0][0] = triangle[0][0];
    	
    	for (int i = 1; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				if(j==0){
					ansTri[i][j]=ansTri[i-1][j]+triangle[i][j];
				}else if(j==i){
					ansTri[i][j]=ansTri[i-1][j-1]+triangle[i][j];
				}else{
					ansTri[i][j]=Math.max(ansTri[i-1][j-1], ansTri[i-1][j])+triangle[i][j];
				}
				
				if(answer<ansTri[i][j])answer=ansTri[i][j];
			}
		}
        return answer;
    }}
