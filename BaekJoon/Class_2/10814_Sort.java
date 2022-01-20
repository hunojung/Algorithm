// 나이순 정렬
// 10814
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int member = Integer.parseInt(br.readLine());
		
		Person[] p = new Person[member];
		
		for (int i = 0; i < member; i++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age=Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			p[i] = new Person(age,name);
		}
		
		Arrays.sort(p, new Comparator<Person>() {
			
			public int compare(Person p1, Person p2){
				return p1.age - p2.age;
			}
			
		});
		
		for (int i = 0; i < member; i++) {
			System.out.println(p[i]);
		}
		
		br.close();
		System.exit(0);
	}
	
	public static class Person{
		int age;
		String name;
		
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return age+" "+name;
		}
	}
}
// 10814 END

// 무지성 코딩
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int member = Integer.parseInt(br.readLine());
		HashMap<Double, String> ageName = new HashMap<>();
		for (int i = 0; i < member; i++) {	
			StringTokenizer st = new StringTokenizer(br.readLine());
			double age=Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
      // 들어온 순서 구분하려고 소수점 추가함
			while(ageName.containsKey(age))age+=0.000001;
			ageName.put(age,name);
		}
    // key 값들을 정렬 시킨 후 나중에 키 값 기준 출력함
		Object[] keylist = ageName.keySet().toArray();
		Arrays.sort(keylist);
    
		for(Object keys : keylist){
			System.out.println((int)(double)keys+" "+ageName.get(keys));
		}
		
		br.close();
		System.exit(0);
	}
}
// 무지성 코딩 정답
