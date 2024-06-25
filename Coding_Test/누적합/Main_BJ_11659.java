import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_11659 {
    public static void main(String[] args)  throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N(수의 개수) 입력 받기
        int M = Integer.parseInt(st.nextToken()); // M(합을 구해야 하는 횟수) 입력 받기
        
        
        st = new StringTokenizer(br.readLine());
        int[] numArr = new int[N+1];
        // N개의 수 입력받기
        for (int i=1;i<=N;i++){
            numArr[i] = numArr[i-1]+Integer.parseInt(st.nextToken());
            //현재 위치까지의 합을 저장
        }

            // M번 연산하기

            for (int i=0;i<M;i++){
            	st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()); // 시작 index
                int end = Integer.parseInt(st.nextToken()); // 끝 index

                System.out.println(numArr[end]-numArr[start-1]); //구간 합을 출력
            }
    } // main
} // end class
