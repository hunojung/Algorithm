// Union_Find
import java.io.*;
import java.util.*;

public class Main {
	static int ans = 0;
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		int[] g = new int[n];
		
		for (int i = 0; i < n; i++) {
			g[i]=i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			a = find(g,a);
			b = find(g,b);
			if(a == b){
				ans = i+1;
				break;
			}else{
				g[b] = a;
			}
		}
		System.out.println(ans);
		br.close();
		System.exit(0);
	}
	
	static int find(int[] g,int n){
		if(g[n]==n) return n;
		return g[n] = find(g,g[n]);
	}
}
-------------------------------------------------------------------------
// 다익스트라
	static int dijkstra (int path,int goal){
		
		boolean[] visit = new boolean[N+1];
		int[] cost = new int[N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		// 시작할 노드를 최솟값으로 설정하고 처음에 걸리게함
		int start = path;
		cost[start]=0;
		
		// 방문 체크하면서 N번하면 모든 노드 들리게 됨
		for (int i = 1; i < N+1; i++) {
			
			// 방문하지 않은 것 중 최솟값인 노드
			int nextNodeCost = Integer.MAX_VALUE;
			for (int j = 1; j < N+1; j++) {
				if(!visit[j] && cost[j]<nextNodeCost){
					nextNodeCost = cost[j];
					start = j;
				}
			}
			
			// 노드 골랐으면 체크
			visit[start]=true;
			
			for (int j = 0; j < arr[start].size(); j++) {
				Node node = arr[start].get(j);
				
				if(cost[node.n]>cost[start]+node.cost){
					cost[node.n]=cost[start]+node.cost;
				}
			}
		}
		return cost[goal];
	}

---------------------------------------------------------------------------------------------

// 콤비네이션 - 연구소 3 문제에서 썼음
static void dfs(int depth, int start){
	if(depth == M){
		bfs();
		return;
	}else{

		for (int i = start; i < arr.size(); i++) {
			Point p = arr.get(i);

			map[p.x][p.y] = 3;
			dfs(depth+1,i+1);
			map[p.x][p.y] = 2;
		}
	}
}


---------------------------------------------------------------------------------------------
// 리스트 돌리기 
from copy import deepcopy 
def rotate(board):
    # tmp = deepcopy(board)
    n = len(board)
    m = len(board[0])
    tmp = [[0 for _ in range(n)] for _ in range(m)]
    for i in range(n):
        for j in range(m):
            tmp[j][n-i-1] = board[i][j]
    return tmp


---------------------------------------------------------------------------------------------
// 진법
def notation(n, base):
  s = "0123456789ABCDEF"
  q, r = divmod(n, base)
  return s[r] if q==0 else notation(q, base) + s[r]
    # tmp = deepcopy(board)
    n = len(board)
    m = len(board[0])
    tmp = [[0 for _ in range(n)] for _ in range(m)]
    for i in range(n):
        for j in range(m):
            tmp[j][n-i-1] = board[i][j]
    return tmp
gcd(최대공약수)
return n
gcd(최대공약수)   
		    
---------------------------------------------------------------------------------------------
// 유클리드 호제법
def gcd(n, m):
  if n > m,
  while m>0:
    n, m = m, n%m
return n

def gcd(n, m):
  return n if m == 0 else gcd(m, n%m)
gcd(n, m) if n>m else gcd(m, n)
- 최소공배수
lcm(최소공배수) = n * m // gcd(최대공약수)


---------------------------------------------------------------------------------------------
// 맵에서 중복된 값은 value를 증가시킨다
TreeMap.put(number,tm.getOrDefault(number, 0) + 1);


---------------------------------------------------------------------------------------------
// Combination N개중 R개 뽑기
public class Main {
	public static void main(String[] args) throws Exception {
		
		int[] list = {0,1,2};
		int n = list.length;
		int r = 2;
		HashSet<Integer> set = new HashSet<>();
		combination(list, n, r, 0, set);
	}

	private static void combination(int[] list, int n, int r, int index, HashSet<Integer> set) {
		if(r==0) {
			for(int i : set) {
				System.out.print(i+" ");
			}System.out.println();
			return;
		}
		
		for(int i=index; i<n; i++) {
			set.add(i);
			combination(list, n, r-1, i+1, set);
			set.remove(i);
		}
		
	}
}


---------------------------------------------------------------------------------------------
// Java Comparator 쓴 문제!!
import java.io.*;
import java.util.*;

class Student implements Comparable<Student>{
	String name;
	int korean;
	int math;
	int english;
	
	public Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	@Override
	public int compareTo(Student s) {
		
		// korean 내림차순 / english 오름차순 / math 내림차순 / name 사전순 증가
		if(this.korean < s.korean){
			return 1;
		}else if(this.korean == s.korean){
			if(this.english > s.english){
				return 1;
			}else if(this.english == s.english){
				if(this.math < s.math){
					return 1;
				}else if(this.math == s.math){
					return this.name.compareTo(s.name);
				}
			}
		}
		return -1;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 값 입력 
		int N = Integer.parseInt(br.readLine());
		List<Student> s = new ArrayList<Student>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int korean = Integer.parseInt(st.nextToken());
			int english = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			s.add(new Student(name,korean,english,math));
		}
		
		Collections.sort(s);	
		
		for (int i = 0; i < N; i++) {
			sb.append(s.get(i).name).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();
		System.exit(0);
	}
}
