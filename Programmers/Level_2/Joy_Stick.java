// 조이스틱
import java.util.Arrays;

public class Solution {

	// testcase 5 : BBBBAABBB
	public int solution(String name) {
		//int[] list ={0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		// 값 입력
		int len = name.length();
		// 가중치로 바꿈
		int[] list = new int[len];
        for (int i = 0; i < len; i++) {
			list[i]= name.charAt(i)>'N'?'Z'-name.charAt(i)+1:name.charAt(i)-'A';
		}
        if(name.length()==1)return name.charAt(0)>'N'?'Z'-name.charAt(0)+1:name.charAt(0)-'A';
        return search(list,len);
    }
	
	static int search(int[] list,int len){
		
		// A가 나온지 여부
		boolean A = false;
		
		// 오른쪽 가다가 턴하는 경우
		int pLen = Arrays.stream(list).sum();
		int p = 0;
		// B B A A B A A A A A A A A / len = 13
		// JAN
		for (int i = 1; i < len; i++) {
			if(!A && (list[i]==0)){
				p = i-1;
				A = true;
			}
			if(A && list[i]!=0){
				pLen += (p + p + (len-i));
				break;
				
			// len 끝까지 A가 반복?이거나 끝까지 A가 안나옴
			}else if(i == len-1){
				if(!A)pLen += len-1;
				else pLen += p;
			}
		}
		
		// 왼쪽 가다가 턴하는 경우 구하기
		int mLen = Arrays.stream(list).sum();
		int m = 0;
		A = false;
		// B B A A B A A A A A B B B / len = 13
		for (int i = len-1; i >= 0; i--) {
			if(!A && list[i]==0){
				m = len-i-1;
				A = true;
			}
			
			if(A && list[i]==0){
				mLen += (m + m + i);
				break;
			}else if( i == 0){
				if(!A)mLen += len-1;
				else mLen+=m;
			}
		}
		
		// 단순 그냥 쭉 더하기
		int Len = Arrays.stream(list).sum();
		for (int i = len-1; i > 0; i--) {
			if(list[i]!=0){
				Len+=i;
				break;
			}
		}

		//System.out.println(pLen+" "+mLen+" "+Arrays.stream(list).sum());
		return Math.min(Len,Math.min(mLen, pLen));
	}
}
