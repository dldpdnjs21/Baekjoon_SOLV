import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16926_1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(tokens.nextToken());
		int M = Integer.parseInt(tokens.nextToken());
		int turn = Integer.parseInt(tokens.nextToken()); //회전 수
		
		int arr[][] = new int[N][M]; //N x M 배열
		
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int i=0; i<turn; i++) { //회전 수만큼 배열 회전
			for(int j=0; j<Math.min(N, M)/2; j++) { //돌려야하는 라인 개수 N,M 중 최솟값/2
				int temp = arr[j][j]; //첫번째 원소 [0][0]에 저장
				//위쪽
				for(int k=j; k<M-j-1; k++) {
					arr[j][k] = arr[j][k+1];					
				}
				//오른쪽
				for(int k=j; k<N-j-1; k++){
					arr[k][M-j-1] = arr[k+1][M-j-1];
				}
				//아래쪽
				for(int k = M-j-1; k>j; k--) {
					arr[N-j-1][k] = arr[N-j-1][k-1];
				}
				//왼쪽
				for(int k=N-j-1; k>j+1; k--) {
					arr[k][j] = arr[k-1][j];
				}
                arr[j+1][j] = temp; //마지막 원소에 첫번째 원소저장
			}
		}
		for(int i = 0; i<N; i++) { //회전된 배열 출력
            for(int j = 0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
	
	}
}
