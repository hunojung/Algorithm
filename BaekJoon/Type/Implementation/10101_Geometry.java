// https://www.acmicpc.net/problem/10101
// 삼각형 외우기
import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		if(a+b+c!=180){
			System.out.println("Error");
		}else if(a==b && b==c){
			System.out.println("Equilateral");
		}else if(a==b || b==c || a==c){
			System.out.println("Isosceles");
		}else{
			System.out.println("Scalene");
		}
		br.close();
		System.exit(0);
	}
}
