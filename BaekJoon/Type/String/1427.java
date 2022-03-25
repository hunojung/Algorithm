// https://www.acmicpc.net/problem/1427
// 소드인사이드
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] arr = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i]=s.charAt(i)-'0';
		}
		Arrays.sort(arr);
		for (int i = s.length()-1; i >-1; i--) {
			System.out.print(arr[i]);
		}
		br.close();
		System.exit(0);
	}
}
