// 전자레인지
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력 
		int num = Integer.parseInt(br.readLine());
		if(num%10 != 0){
			System.out.println(-1);
			System.exit(0);
		}
		
		int[] button = {300,60,10};
		int[] time = new int[3];
		
		for (int i = 0; i < 3; i++) {
			
			int next = button[i];
			//System.out.println(num+" "+next+" "+index);
			if(num>=next){
				time[i]=num/next;
				num-=time[i]*next;
			}
		}
		
		System.out.println(time[0]+" "+time[1]+" "+time[2]);
		
		br.close();
		System.exit(0);
	}
}
