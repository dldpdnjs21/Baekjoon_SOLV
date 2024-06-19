import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_10163 {
    public static void main(String[] args)  throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());   // 색종이의 개수 입력받기

        int[][] arr = new int[1001][1001]; // 가로 세로 최대 1001칸

        // 색종이가 놓여진 위치 각자의 번호로 표시하기
        // 색종이의 번호는 1번부터 시작하므로 k=1로 시작
        for(int k=1;k<=N;k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // x 좌표
            int y = Integer.parseInt(st.nextToken()); // y 좌표
            int w = Integer.parseInt(st.nextToken()); // 너비
            int h = Integer.parseInt(st.nextToken()); // 높이

            for(int i=x;i<x+w;i++){
                for(int j=y; j<y+h;j++){
                    arr[i][j] = k;   // 현재 색종이 번호 넣어주기
                }
            }
        }

        for (int k =1; k<=N;k++) {
            int count = 0;
            for (int i = 0; i < 1001; i++) {
                for (int j = 0; j < 1001; j++) {
                    if (arr[i][j] == k) {
                        count++; // k 색종이 면적끼리 더하기
                    }
                }
            }
            System.out.println(count); // 각 색종이 별 면적 총 합 출력
        }
    } // main
} // end class