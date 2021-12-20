// 단어 정렬
// 1181
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		String[] list = new String[num];
		int maxlen=0;
		String bstring = "";
		for (int i = 0; i < num; i++) {
			list[i] = br.readLine();
			if(maxlen<list[i].length())maxlen=list[i].length();
		}
		
		Arrays.sort(list);
		for (int i = 0; i <= maxlen; i++) {
			for (String string : list) {
				if((string.length()==i)&&!(bstring.equals(string))){
                    System.out.println(string);
				    bstring = string;
                }
			}
		}
		
		br.close();
		System.exit(0);

	}

}
// 1181END
