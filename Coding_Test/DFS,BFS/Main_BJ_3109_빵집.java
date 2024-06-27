import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_3109_빵집 {
	static int R,C;
	static char[][] map;
	static int count = 0;
	static boolean[][] check;
	static int[] dr = {-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String line = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		// 0~R-1순으로 출발점 설정
		for(int i=0; i<R; i++) {
			dfs(0,i);
			}
		System.out.println(count);
		}
	
	static boolean dfs(int x, int y) {
		for(int i=0; i<3; i++) {
			int nx = x + 1;
			int ny = y + dr[i];
			if(nx<0 || nx>C-1 || ny<0 || ny>R-1) continue;
			if(map[ny][nx] =='.') {
				if(nx == C-1) {
					count ++;
					return true;
					}
				map[ny][nx] = '-';
				if(dfs(nx,ny)) return true;
				}
			}
		return false;
		}
}

