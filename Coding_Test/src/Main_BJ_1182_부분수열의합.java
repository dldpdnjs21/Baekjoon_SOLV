import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1182_부분수열의합 {
	public static int N, S;
	public static int arr[];
	public static int count=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		
		if(S==0) {
			count--;
		}
		System.out.println(count);
	}//main
	
	private static void dfs(int depth, int sum) {
		if(depth == N) { //depth가 마지막까지 갔을 경우
			if(sum==S) { //그 중에 sum이 타깃 넘버일 경우
				count++;
			}
			return;
		}
		dfs(depth+1,sum+arr[depth]); //원소를 선택했을 경우 수열의 합
		dfs(depth+1,sum); //원소를 선택하지 않았을 경우 수열의 합
	}//dfs
}//end class