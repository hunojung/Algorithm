// 수 정렬하기 2
// 2751
// 병합 정렬 적용
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
    static int[] sortedArr;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
        sortedArr = new int[N];
        int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
		}
		
        mergeSort(arr,0,N-1);
		StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);

		br.close();
		System.exit(0);
	}
    
    static void mergeSort(int[] arr , int start , int end){
        
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            arrSort(arr, start, mid, end);
        }
    }
    
    static void arrSort(int[] arr , int start, int mid, int end){
        int idx = start;
        int idx1 = start;
        int idx2 = mid+1;
        while(idx1 <= mid && idx2 <= end){
            if(arr[idx1] > arr[idx2]){
                sortedArr[idx] = arr[idx2];
                idx2++;
            }else{
                sortedArr[idx] = arr[idx1];
                idx1++;
            }
            idx++;
        }
        
        while(idx1<=mid){
            sortedArr[idx] = arr[idx1];
            idx++;
            idx1++;
        }
        
        while(idx2<=end){
            sortedArr[idx] = arr[idx2];
            idx++;
            idx2++;
        }
        
        for(int i= start;i<=end;i++){
            arr[i] = sortedArr[i];
        }
    }
}


// 이전 제출
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


// BufferedReader + ArrayList + Collections.sort : 시간초과
// BufferedReader + int[] + Arrays.sort : 시간초과
// BufferedReader + PriorityQueue : 통과
// Scanner + ArrayList + Collections.sort : 통과
// BufferedReader + ArrayList + Collections.sort : 통과 Scanner보다 시간/ 메모리 적게 들어감


public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner in = new Scanner(System.in);
		
//		int N = in.nextInt();
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder str = new StringBuilder();
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < N; i++) {
//			numbers.add(in.nextInt());
			numbers.add(Integer.parseInt(br.readLine()));
		}
		
		// Arrays.sort : 시간초과
		Collections.sort(numbers);
		
		for (int i = 0; i < N; i++) {
			
			// System.out.println(numbers.remve(0)) : 시간초과
			// numbers.remove(0) : 시간초과
			str.append(numbers.get(i)).append('\n');
		}
		
		System.out.println(str);

		br.close();
		System.exit(0);
	}
}
// 2751 END
