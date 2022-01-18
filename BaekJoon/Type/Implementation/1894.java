// https://www.acmicpc.net/problem/1894
// 4번째 점

// 분류
// 구현
// 기하학
// 많은 조건 분기
import java.io.*;
import java.util.*;

public class Main{
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      //Scanner input=new Scanner(System.in);
      // 값 입력
      StringTokenizer st;
      String line;
      while((line = br.readLine()) != null && !line.isEmpty()){
         st = new StringTokenizer(line);
         //System.out.println(input.hasNext());
         // line1 의 점 2개 좌표
         double[] p1 = {Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())};
         double[] p2 = {Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())};   

         // line2 의 점 2개 좌표
         double[] p3 = {Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())};
         double[] p4 = {Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken())};
         double x = 0, y = 0;
         if (p1[0] ==p3[0] && p1[1] == p3[1]) {
            x = p2[0] + p4[0] - p1[0];
            y = p2[1] + p4[1] - p1[1];
         }
         else if(p1[0] ==p4[0] && p1[1] == p4[1]) {
            x = p2[0] + p3[0] - p1[0];
            y = p2[1] + p3[1] - p1[1];
         }
         
         else if (p2[0] ==p4[0] && p2[1] == p4[1]) {
            x = p1[0] + p3[0] - p2[0];
            y = p1[1] + p3[1] - p2[1];
         }
         
         else if (p2[0] ==p3[0] && p2[1] == p3[1]) {
            x = p1[0] + p4[0] - p2[0];
            y = p1[1] + p4[1] - p2[1];
         }
    
         System.out.println(String.format("%.3f %.3f",x,y));
      }
      br.close();
      System.exit(0);
   }
}
