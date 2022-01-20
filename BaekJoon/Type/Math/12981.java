// https://www.acmicpc.net/problem/12981
// 공 포장하기

// 분류
// 수학
// 그리디 알고리즘
// 많은 조건 분기
import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] num = new int[3];
		num[0] = Integer.parseInt(st.nextToken());
		num[1] = Integer.parseInt(st.nextToken());
		num[2] = Integer.parseInt(st.nextToken());
		
		int box = 0;
		
		while(num[0]>0 || num[1]>0 || num[2]>0){
			
			//R,G,B != 0
			if(num[0]*num[1]*num[2]!=0){
				num[0]--;
				num[1]--;
				num[2]--;
				box++;
			
			//R*G*B==0
			}else{
				// 0, 1, 2 순으로 커지게 정렬
				num = sort(num);
				
				// 1이 0이아니면 2도 아니다
				if(num[1]!=0){
					
					// 1 일경우에만 1,2 박스에 같이 담기
					if(num[1]==1){
						num[1]--;
						num[2]--;
						box++;
					}else{
						num[1]-=3;
						box++;
					}
				}else{
					num[2]-=3;
					box++;
				}
			}
		}
		
		System.out.println(box);
		br.close();
		System.exit(0);
	}
    
    static int[] sort(int[] num){
    	
    	for (int j = 0; j < num.length-1; j++) {			
    		for (int i = 0; i < num.length-1; i++) {
    			if(num[i]>num[i+1]){
    				int temp = num[i];
    				num[i]=num[i+1];
    				num[i+1]=temp;
    			}
    		}
		}
    	return num;
    }
}
