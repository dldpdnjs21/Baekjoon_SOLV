import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_1260_DFS와BFS {
	static int N, V;
	static boolean adjMatrix[][];
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //정점수
		int M = sc.nextInt(); //간선수
		V = sc.nextInt();//시작지점
		
		adjMatrix = new boolean[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = true;
		}
		//DFS
		dfs(V,new boolean[N+1]);
		
		System.out.println();
		
		//BFS
		bfs();
		
		sc.close();
	}//main
	

	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.print(current+" ");
		
		for(int i=0; i<N+1; i++) {
			if(adjMatrix[current][i] && !visited[i]) {
				dfs(i,visited);
			}
		}
		
	}//dfs

	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean visited[] = new boolean[N+1];
		
		queue.offer(V);
		
		visited[V] = true;
		
		while(!queue.isEmpty()) {
			V = queue.poll();
			
			System.out.print(V+" ");
			
			for(int i=0; i<N+1; i++) {
				if(!visited[i] && adjMatrix[V][i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}//while
	}//bfs
}
