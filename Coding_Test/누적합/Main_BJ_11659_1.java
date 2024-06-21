import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11659_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(tokens.nextToken()); // N(수의 개수) 입력 받기
        int M = Integer.parseInt(tokens.nextToken()); // M(합을 구해야 하는 횟수) 입력 받기

        int[] arr = new int[N+1];
        int[] sumArr = new int[N+1]; //구간 배열

        // N개의 수 입력받기
        tokens = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
            sumArr[i] = sumArr[i-1] + arr[i];
        }

        for (int i=0; i<M; i++) {
            tokens = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tokens.nextToken());
            int end = Integer.parseInt(tokens.nextToken());
            
            System.out.println(sumArr[end]-sumArr[start-1]);
        }
    }
}