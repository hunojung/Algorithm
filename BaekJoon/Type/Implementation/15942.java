// https://www.acmicpc.net/problem/15947
// 아기 석환 뚜루루 뚜루

// 분류
// 구현
// 많은 조건 분기
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 값 입력
		int N = Integer.parseInt(br.readLine());
		
		String[] song = {"baby", "sukhwan", "tururu", "turu",
				"very", "cute", "tururu", "turu",
				"in", "bed", "tururu", "turu",
				"baby", "sukhwan"};
		
		int len = song.length;
		int repeat = (N-1)/len;
		
		int ansIndex = (N%len==0?14:N%len)-1;
		
		if(ansIndex == 2 || ansIndex ==3|| ansIndex ==6|| ansIndex ==7|| ansIndex ==10|| ansIndex ==11){
			int lenth = (song[ansIndex].length()+repeat*2);
			if(lenth>11){
				song[ansIndex]="tu+ru*"+(lenth-2)/2;
            }else{
				for (int i = 0; i < repeat; i++) {
					song[ansIndex]+="ru";
				}
			}			
		}
		System.out.println(song[ansIndex]);
		
		br.close();
		System.exit(0);
	}
}
