// 1307
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[][] mabang = new int[num][num];
		boolean even=true;
		int type = 0;
		int count = 1;
		
		if(num%4==0){ // 4의 배수인 경우
						for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					
					if((i%4==0||i%4==3)&&(j%4==0||j%4==3)||(i%4==1||i%4==2)&&(j%4==1||j%4==2)){
						even=true;
					}else{
						even=false;
					}
					
					if(even==true)mabang[i][j]=count;
					else mabang[i][j]=num*num-count+1;
					count++;
				}
			}
			
		}else if(num%2 != 0){ // 홀수인 경우
			int row = 0;
			int col = num/2;
			count = 0;
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					count++;
					mabang[row][col] = count;
					row--;
					if(row < 0)row = num-1;
					col++;
					if(col ==num )col=0;
				}
				row++;
				if(row == num)row = 0;
				col--;
				if(col<0)col=num-1;
				row++;
				if(row == num)row = 0;
	
			}
		}else{ // 4의 배수가 아니면서 짝수인 경우
			
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					if(i==j || (i+j==num-1)){// 대각선
						type = 0;
					}else if(((j>1 && (i>2 && i<num-3))||((j>2)&&(i<3 || i>num-4)))&&// 타입 2 제한구역
							((i<num/2&&j<num/2)&&((j>i&&(j+i)%2==0)||(j<i&&(j+i)%2!=0))||
							(i>=num/2&&j<num/2)&&(((num-j)>i&&(j+i)%2==0)||((num-j)<=i&&(j+i)%2!=0))||
							(i<num/2&&j>=num/2)&&((j<(num-i)&&(j+i)%2!=0)||(j>=(num-i)&&(j+i)%2==0))||
							(i>=num/2&&j>=num/2)&&(((num-j)<(num-i)&&(j+i)%2!=0)||((num-j)>(num-i)&&(j+i)%2==0)))){
						type = 2;
					}else if(((i>1 && (j>2 && j<num-3))||((i>2)&&(j<3 || j>num-4)))&&// 타입 3 제한구역
							((j<num/2&&i<num/2)&&((i>j&&(j+i)%2==0)||(i<j&&(j+i)%2!=0))||
							(j>=num/2&&i<num/2)&&(((num-i)>j&&(j+i)%2==0)||((num-i)<=j&&(j+i)%2!=0))||
							(j<num/2&&i>=num/2)&&((i<(num-j)&&(j+i)%2!=0)||(i>=(num-j)&&(j+i)%2==0))||
							(j>=num/2&&i>=num/2)&&(((num-i)<(num-j)&&(j+i)%2!=0)||((num-i)>(num-j)&&(j+i)%2==0)))){
						type = 3;
					}else{
						type =1;
					}
					if(type == 0)mabang[i][j] = i*num+(j+1); // 대각선
					else if(type == 1)mabang[i][j] = num*num - i*num-j; // 대각선 아님
					else if(type == 2)mabang[i][j] = i*num+(num-j);
					else mabang[i][j] = (num-i-1)*num+(j+1);
				}
			}
		}
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if(j>0)System.out.print(" ");
				System.out.print(mabang[i][j]+" ");
			}
			System.out.println("");
		}
		
		br.close();
		System.exit(0);
	}
}
// 1307 end
