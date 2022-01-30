// https://www.acmicpc.net/problem/2477
// 참외밭

// 분류
// 구현
// 기하학
// 애드 혹
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] point = new int[12];
		int maxX = 0;
		int maxY = 0;
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			if(direction==1){
				if(distance>maxX)maxX=distance;
				point[i]=distance;
				point[i+6]=distance;
			}else if(direction==2){
				if(distance>maxX)maxX=distance;
				point[i]=distance;
				point[i+6]=distance;
			}else if(direction==3){
				if(distance>maxY)maxY=distance;
				point[i]=distance;
				point[i+6]=distance;
			}else{
				if(distance>maxY)maxY=distance;
				point[i]=distance;
				point[i+6]=distance;
			}
		}
		
		int area = maxX*maxY;
		for (int i = 0; i < 12; i++) {
			if(point[i]==maxX && point[i+1]==maxY){
				area-=point[i+3]*point[i+4];
				break;
			}
			
			if(point[i]==maxY && point[i+1]==maxX){
				area-=point[i+3]*point[i+4];
				break;
			}
		}
		
		System.out.println(area*N);
		
		br.close();
		System.exit(0);
	}
}
