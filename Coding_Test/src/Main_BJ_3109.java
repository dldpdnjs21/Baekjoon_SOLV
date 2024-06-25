import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Main_BJ_3109 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int R, C;
	static char[][] map;
	
	//이동방향 - 순서가 중요하다
	static int[] deltas = {-1,0,1}; //대각선 위, 오른쪽, 아래
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		R = Integer.parseInt(tokens.nextToken());
		C = Integer.parseInt(tokens.nextToken());
		
		map = new char[R][];
		for(int r=0; r<R; r++) {
			map[r] = input.readLine().toCharArray();
		}
		//입력완료
		//각 row별로 dfs 탐색을 돌아보자
		int answer = 0;
		for(int r=0; r<R; r++) {
			//dfs탐색
			boolean result = makePipe(r,0);
			if(result) {
				answer++;
			}
		}
		//결과출력
		System.out.println(answer);
	}
	
	private static boolean makePipe(int r, int c) {
		//기저조건
		if(c==C-1) {
			return true;
		}
		//3방향으로 표시하면 가보기
		for(int j=0; j<deltas.length; j++) {
			int nr = r + deltas[j];
			int nc = c + 1;
			
			if(isIn(nr,nc)&& map[nr][nc]=='.') {
				//지나온 지점에 대해서 표시(방문체크)
				map[nr][nc] = 'X';
				boolean result = makePipe(nr, nc);
				if(result) {
					return true;
				}
				//안한척 하기... 이미 한 녀석이 지나온 길은 파이프가 매설되었거나, 매설 불가한 지역이다.
				//map[nr][nc]='.';
			}//if
		}//for
		return false;
	}
	//(r,c)가 유효한 범위 내에 있는지 확인
	//행(r)과 열(c)이 0 이상이고, R미만, C미만인지
	private static boolean isIn(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
	
	
	private static String src="5 5\r\n"
			+ ".xx..\r\n"
			+ "..x..\r\n"
			+ ".....\r\n"
			+ "...x.\r\n"
			+ "...x.";
	
}
