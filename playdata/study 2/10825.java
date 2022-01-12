// 국영수
import java.io.*;
import java.util.*;

class Student implements Comparable<Student>{
	String name;
	int korean;
	int math;
	int english;
	
	public Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	@Override
	public int compareTo(Student s) {
		
		// korean 내림차순 / english 오름차순 / math 내림차순 / name 사전순 증가
		if(this.korean < s.korean){
			return 1;
		}else if(this.korean == s.korean){
			if(this.english > s.english){
				return 1;
			}else if(this.english == s.english){
				if(this.math < s.math){
					return 1;
				}else if(this.math == s.math){
					return this.name.compareTo(s.name);
				}
			}
		}
		return -1;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력 
		int N = Integer.parseInt(br.readLine());
		List<Student> s = new ArrayList<Student>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			s.add(new Student(name,korean,english,math));
		}
		
		Collections.sort(s);	
		
		for (int i = 0; i < N; i++) {
			sb.append(s.get(i).name).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
}
