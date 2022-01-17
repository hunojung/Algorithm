// 채식주의자
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		double x = Double.parseDouble(st.nextToken());
		double y = Double.parseDouble(st.nextToken());
		
		double ansX = 0;
		double ansY = 0;
		//  삼각형의 반 넓이
		double area = (250*250/2)/2;
		
		
		// 0,y ( y<=125 ) - 답은 빗변 
		// ((250-y)*ansX)/2 = area
		if(x == 0 && y<=125){
			ansX = 2*area/(250-y);
			ansY = 250-ansX;
		
		// 0,y( y>125 ) - 답은 x 축
		// ansX*y/2 = area
		}else if( x== 0 && y > 125 && y < 250){
			ansX = area*2/y;
			ansY = 0;
			
		// x,0 ( x<=125) - 답은 빗변
		// ((250-x)*ansY)/2 = area
		}else if(y==0 && x<=125){
			ansY = 2*area/(250-x);
			ansX = 250-ansY;
			
		// 0,y( y>125 ) - 답은 y 축
		// ansY*x/2 = area	
		}else if(y==0 && x > 125 && x < 250){
			ansY = area*2/x;
			ansX = 0;
			
		// x 또는 y 가 250일 때
		}else if(x==250 || y== 250){
			ansX = y/2;
			ansY = x/2;
		
		// 빗변 중 아래부분 - 답은 y축 위에
		// ((250-ansY)*x/2 = area
		}else if(x >= 125 && y <= 125){
			ansY = 250-2*area/x;
			ansX = 0;
			
		// 빗변 중 위부분 - 답은 x축 위에
		// ((250-ansX)*y/2 = area
		}else if(x < 125 && y > 125){
			ansX = 250-2*area/y;
			ansY = 0;
		}
		
		System.out.println(String.format("%.2f %.2f",ansX,ansY));
	}
}
