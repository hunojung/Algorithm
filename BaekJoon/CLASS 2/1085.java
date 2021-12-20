// 직사각형에서 탈출
// 1085
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int xw = w-x>x?x:w-x;
		int yh = h-y>y?y:h-y;
		
		int ans = xw>yh?yh:xw;
		
		
		System.out.println(ans);
		
		br.close();
		System.exit(0);

	}

}

// 1085 END
