// 리모콘
// 1107
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력
		int num = Integer.parseInt(br.readLine()); // 목표 채널
		int testnum = num; // 테스트할 변수에 저장
		int testcase = Integer.parseInt(br.readLine()); // 부서진 버튼 수
		HashSet<Integer> broken = new HashSet<>(); // 부서진 버튼 저장할 변수
		StringTokenizer st = null;
		if(testcase != 0) st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < testcase; i++) {
			broken.add(Integer.parseInt(st.nextToken()));		
		}
		// 값 입력 끝
		
		// min, max 및 다른 설정
		int count = Math.abs(num-100);
		boolean zero = true; // true면 0이 broken에 포함
		if(!broken.contains(0)){ // 0이 broken에 없으면 min 결정할때 잠깐 0 을 제외하고 설정
			zero = false;
			broken.add(0);
		}
		
		
		int max = 0;
		int min = 10;
		for (int i = 0; i < 10; i++) {
			if(!broken.contains(i)){
				if(max<i)max=i;
				if(min>i)min=i;
			}
		}
		
		//System.out.println(max+" "+min);
		int maxRange = min;
		int minRange = 0;
		if(!zero){
			min=0;
			broken.remove(0);
		}
		
		int len = 0;
		while(testnum>0){
			len++;
			maxRange=maxRange*10+min;
			minRange=minRange*10+max;
			testnum/=10;
		}
		minRange/=10;
		
		//System.out.println(num+" "+maxRange+" "+minRange);
		if(maxRange>1000000)maxRange=1000000;
		for (int i = minRange ; i < maxRange+1; i++) {
			
			// broken이 숫자에 포함되었나
			int numI=i;

			len=0; // 버튼 누른 횟수 넣기
			int lenI=i;
			while(lenI>0){len++;lenI/=10;}
			if(i==0)len=1;
			boolean contain = false;
			for (int j = 0; j < len; j++) {
				if(broken.contains(numI%10)){
					contain=true;
					continue;
				}else{
					numI/=10;
				}
			}
			if(contain)continue;
			
			int countNext = Math.abs(num-i)+len; // count 비교할 변수
			if(count>countNext){ // count 비교
				count=countNext;
				//System.out.println(num+" "+i+" "+lenI);
			}
		}
		
		System.out.println(count);
		
		br.close();
		System.exit(0);
	}
}
// 1107 END
