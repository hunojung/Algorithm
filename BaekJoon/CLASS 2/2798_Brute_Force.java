// 블랙잭
// 2798
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		ArrayList<Integer> numbers = new ArrayList<>();
		int sum = 0;
		int nextNum;
		
		st = new StringTokenizer(br.readLine());
		while(N-- > 0){
			nextNum = Integer.parseInt(st.nextToken());
			if(nextNum<goal){
				numbers.add(nextNum);
			}
		}
		
		Collections.sort(numbers);
		int i=0;
		int j=i;
		int k=j;
		int compSum = 0;
		int size = numbers.size();
		while(true){
			compSum=numbers.get(i)+numbers.get(j)+numbers.get(k);
			if(compSum==goal){
				sum=compSum;
				break;
			}else if(compSum < goal && compSum > sum){
				sum = compSum;
			}
			k++;
			if(k==size){
				j++;
				if(j==size-1){
					i++;
					j=i+1;
					if(i==size-2)break;
				}
				k=j+1;
			}
		}
		
		System.out.println(sum);
		br.close();
		System.exit(0);
	}
}

// 2798 END
