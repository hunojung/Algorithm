// 프린터 큐
// 1966
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());

		while(testcase-->0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int count =0;
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> numbers = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				numbers.add(Integer.parseInt(st.nextToken()));	
			}
			
			while(true){
        
        //index 0 값이 MAX 가 아닐경우 맨끝으로 넘김
				if(Collections.max(numbers)>numbers.get(0)){
					
					numbers.add(numbers.remove(0));
					if(M==0){
						M=numbers.size()-1;
					}else{
						M--;
					}
         
        //index 0 값이 MAX 일경우 제거
				}else{
					count++;
					numbers.remove(0);
					if(M==0){
						System.out.println(count);
						break;
					}else{
						M--;
					}
				}
			}
		}
		
		br.close();
		System.exit(0);
	}
}
//END 1966
