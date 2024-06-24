import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1931_회의실배정 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //회의타임 개수 
		int time[][] = new int[N][2]; 
		int T = 0; //겹치지 않는 회의의 최대 개수
		StringTokenizer tokens;
		
		for(int i=0; i<N; i++) {
			tokens = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(tokens.nextToken());
			time[i][1] = Integer.parseInt(tokens.nextToken());
		}
			
		Arrays.sort(time, (a1, a2) -> a1[1]==a2[1] ? a1[0]-a2[0] : a1[1]-a2[1]); //끝나는 시간이 같다면 시작 시간 순으로 정렬 
		
		int end = -1;
		
		for(int i=0; i<N; i++) {
			if(time[i][0] >= end) {//만약 회의 시작 시간이 끝나는 시간과 같다면 해당 회의의 종료 시각으로 변경
				end=time[i][1];
				T++;
			}
			
		}
		System.out.println(T);
	}
}