// https://www.acmicpc.net/problem/1715
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }
        int count = 0;
        while(pq.size()>1){
            int num1 = pq.poll();
            int num2 = pq.poll();
            pq.add(num1+num2);
            count += num1+num2;
        }
        
        System.out.println(count);
        br.close();
        System.exit(0);
    }
}
