// 집합
// 배열 풀이
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		String order;
		int number;
    
    // 단순 System.out.println(); 사용시 시간초과 발생
		StringBuilder sb = new StringBuilder();
		
		int[] num_set=new int[22];
		
		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			order = st.nextToken();
			
			if(order.equals("add")){
				number = Integer.parseInt(st.nextToken());
				num_set[number]=1;
			}else if(order.equals("remove")){
				number = Integer.parseInt(st.nextToken());
				num_set[number]=0;
			}else if(order.equals("check")){
				number = Integer.parseInt(st.nextToken());
				sb.append(num_set[number]==1?1:0).append("\n");
			}else if(order.equals("toggle")){
				number = Integer.parseInt(st.nextToken());
				num_set[number]=num_set[number]==1?0:1;
			}else if(order.equals("all")){
				//num_set.addAll(one_to_twenty);
				Arrays.fill(num_set, 1);
			}else if(order.equals("empty")){
				//num_set.clear();
				num_set = new int[21];
			}
		}
		
		System.out.println(sb);
		br.close();
		System.exit(0);
	}
}
// 배열풀이 END

// 비트마스크
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int s = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "all":
                    s = (1 << 21) - 1;
                    break;
                case "empty":
                    s = 0;
                    break;
                default:
                    int x = Integer.parseInt(input[1]);
                    switch (input[0]) {
                        case "add":
                            s |= (1 << x);
                            break;
                        case "remove":
                            s &= ~(1 << x);
                            break;
                        case "check":
                            sb.append((s & (1 << x)) != 0 ? 1 : 0).append('\n');
                            break;
                        case "toggle":
                            s ^= (1 << x);
                            break;
                    }
            }
        }

        System.out.println(sb);
    }
}
// 비트마스크 END
