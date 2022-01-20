// Z
// 1074
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		
		int N = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int count = Z(0,0,0,x,y);
		
		System.out.println(count);
		System.exit(0);
	}
	
	public static int Z(int count,int xRange,int yRange,int x, int y){
		System.out.println(count+" "+xRange+" "+yRange+" "+x+" "+y);
		int bigRange=xRange>yRange?xRange:yRange;
		int add = (int)Math.pow(2, bigRange)*(int)Math.pow(2, bigRange);
		
		// 가장 작은 사각형부터 넓혀 나감, 사실상 N을 받을 필요없음..
		if(x >= Math.pow(2, xRange+1)){
			return Z(count,xRange+1,yRange,x,y);
		}else if(y >= Math.pow(2, yRange+1)){
			return Z(count,xRange , yRange+1 , x,y);
		}else if(xRange == 0 && yRange == 0){
			// 끝
			return count+x*2+y;
		}
	
		// 넓혀 나가다가 안 넓혀질때 몇사분면인지 나누어서 반복
		if(xRange>yRange){
			count= count + 2*add;
			return Z(count,0,0,x>1?xRange==0?x:(x-(int)Math.pow(2, xRange)):x,y);
		}else if(xRange == yRange){
			count=count + 3*add;
			return Z(count,0,0,x>1?xRange==0?x:(x-(int)Math.pow(2, xRange)):x,y>1?yRange==0?y:(y-(int)Math.pow(2, yRange)):y);
		}else{
			count=count + add;
			return Z(count,0,0,x,y>1?yRange==0?y:(y-(int)Math.pow(2, yRange)):y);
		}
	}
}
// 1074 END
