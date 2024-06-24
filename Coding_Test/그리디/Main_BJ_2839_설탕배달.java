import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_2839_설탕배달 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //설탕 kg
		int result = 0;
		
		while(N>0) { //설탕의 양이 양수일때
			if(N%5==0) {// 설탕의 양이 5로 나눠질 수 있으면
				result += N/5; //5로 나눈 몫을 result에 더한다
				System.out.println(result);
				return;
			} else if(N<3) {//설탕의 양이 최소 무게 3보다 작으면 '-1' 출력
				System.out.println("-1");
				return;
			}
			N-=3;//설탕의 양이 5로 안나눠질 경우에는 3kg 하나를 카운트
			result++;
		}
		System.out.println(result);
	}
}
