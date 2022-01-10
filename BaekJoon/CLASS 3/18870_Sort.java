// 좌표 압축
// 시간초과 오답
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력
		int N = Integer.parseInt(br.readLine());
		int[] X = new int[N];
		
		// 오름차순 정렬 >> 인덱스 = 해당 값보다 작은게 몇개인가? 중복된건 순위 안매김
		ArrayList<Integer> sortX = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			X[i] = Integer.parseInt(st.nextToken());
			if(!sortX.contains(X[i])) sortX.add(X[i]);
		}
		
		Collections.sort(sortX);
		HashMap<Integer, Integer> hm = new HashMap<>();
			
		for (int i = 0; i < sortX.size(); i++) {
			hm.put(sortX.get(i), i);
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(hm.get(X[i])+" ");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// System.out.println(sb);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		System.exit(0);
	}
}
// 오답 END

// 정답
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력
		int N = Integer.parseInt(br.readLine());
		int[] X = new int[N];
		int[] X2 = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			X2[i] = X[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(X2);
		HashMap<Integer, Integer> hm = new HashMap<>();
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			if(hm.containsKey(X2[i]))continue;
			hm.put(X2[i], cnt++);
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(hm.get(X[i])+" ");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//System.out.println(sb);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		System.exit(0);
	}
}
// 18870 END
