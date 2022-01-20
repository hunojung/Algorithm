// 숫자 카드 2
// 10816
import java.io.*;
import java.util.*;

public class Main {
	static int[] arrN;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
		int num=Integer.parseInt(br.readLine());
		arrN=new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		ArrayList<Integer> numList=new ArrayList<>();
		for (int i = 0; i < num; i++) {
			arrN[i]=(Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arrN);
			
		int snum=Integer.parseInt(br.readLine());
		ArrayList<Integer> snumList=new ArrayList<>();
		
		StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < snum; i++) {
			int number = Integer.parseInt(st2.nextToken());
			bw.append((upper_bound(number)-lower_bound(number))+ " ");
      	}
		
        bw.close();
		br.close();
		System.exit(0);			
	}

	static int lower_bound(int num) {
		int start = 0, last = arrN.length, mid;
		while(start<last) {
			mid = start + (last-start)/2;
			if(num <= arrN[mid]) {
				last = mid;
			}
			else {
				start = mid+1;
			}
		}
		return start;
	}
  
	static int upper_bound(int num) {
		int start = 0, last = arrN.length, mid;
		while(start < last) {
			mid = start + (last-start)/2;
			if(num >=arrN[mid])
				start = mid +1;
			else
				last = mid;
		}
		return start;
	}
}


// 10816 END
