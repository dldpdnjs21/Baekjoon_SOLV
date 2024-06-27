import java.util.Scanner;

public class Main {
	static int R, C;
	static char[][] board;
	static boolean[] visited;
	static int answer = 1;
	static int max = 0;
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		board = new char[R][C];
		visited = new boolean[26];
		
		for(int i=0; i<R; i++) {
			String S = sc.next();
			for(int j=0; j<C; j++) {
				board[i][j] = S.charAt(j);
			}
		}
		visited[board[0][0]-'A'] = true;
		
		dfs(0,0);
		System.out.println(answer);
		
		sc.close();
		
	}

	private static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int nx = x + dx[i]; 
			int ny = y + dx[i]; 
			
			if(nx < 0 || nx >= R || ny < 0 || ny >= C) {
				continue;
			}
			if(isValid(nx, ny)) {
                visited[board[nx][ny] - 'A'] = true;
                answer++;
                dfs(nx, ny);
                visited[board[nx][ny] - 'A'] = false;
                answer--;
            }
		}
		 max = Math.max(answer, max);
	}

	private static boolean isValid(int x, int y) {
		if(x >= 0 && y < R && x >= 0 && y < C && !visited[board[x][y] - 'A'])return true;
		return false;
	}
	
}
