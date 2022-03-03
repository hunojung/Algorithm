// https://www.acmicpc.net/problem/16486
// 운동장 한 바퀴
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int d1 = Integer.parseInt(br.readLine());
		int d2 = Integer.parseInt(br.readLine());
		System.out.println(2*(d1+3.141592*d2));
		br.close();
		System.exit(0);
	}
}
