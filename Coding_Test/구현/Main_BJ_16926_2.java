import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_16926_2 {

	static int n, m, r;
	static int r_num;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫째 줄
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		// 배열 채우기
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			StringTokenizer st_a = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st_a.nextToken());
			}
		}

		// 회전 시킬 그룹 개수
		r_num = Math.min(n, m) / 2;

		for (int i = 0; i < r; i++) {
			rotate();
		}

//		  배열 확인
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void rotate() {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		for (int r = 0; r < r_num; r++) {
			int x = r;
			int y = r;

			int tmp = arr[x][y];
			int nx, ny;

			int idx = 0;
			while (idx < 4) {
				nx = x + dx[idx];
				ny = y + dy[idx];

				if (nx < n - r && ny < m - r && nx >= r && ny >= r) {
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				}

				else {
					// 범위를 넘어가는 경우 = 모서리에 도달한 경우. idx값을 증가시켜 꺾어줌.
					idx++;
				}
			}
			arr[r + 1][r] = tmp;
		}
	}
}
