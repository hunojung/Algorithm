// https://www.acmicpc.net/problem/12852
// 1로 만들기 2
import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[][] nums = new int[num+1][2];
		
		for(int i = 1;i<num;i++) {
			if(nums[i+1][0]==0) {
				nums[i+1][0] = nums[i][0]+1;
				nums[i+1][1] = i;
			}else {
				if(nums[i+1][0]>nums[i][0]+1) {
					nums[i+1][0] = nums[i][0]+1;
					nums[i+1][1] = i;
				}
			}
			
			if(i*2>num) continue;
			if(nums[i*2][0]==0) {
				nums[i*2][0] = nums[i][0]+1;
				nums[i*2][1] = i;
			}else {
				if(nums[i*2][0]>nums[i][0]+1) {
					nums[i*2][0] = nums[i][0]+1;
					nums[i*2][1] = i;
				}
			}
			
			if(i*3>num) continue;
			if(nums[i*3][0]==0) {
				nums[i*3][0] = nums[i][0]+1;
				nums[i*3][1] = i;
			}else {
				if(nums[i*3][0]>nums[i][0]+1) {
					nums[i*3][0] = nums[i][0]+1;
					nums[i*3][1] = i;
				}
			}
			
		}
		
		System.out.println(nums[num][0]);
		
		int idx = num;
		while(idx>0) {
			System.out.print(idx+" ");
			idx = nums[idx][1];
		}
		
		

		br.close();
		System.exit(0);
	}
}
