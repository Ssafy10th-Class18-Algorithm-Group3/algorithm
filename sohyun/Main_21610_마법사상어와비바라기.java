import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_21610_마법사상어와비바라기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] A;
	static int d[], s[];

	static int[][] delta = { {}, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } // 왼, 좌상, 위, 우상
			, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } }; // 오, 우하, 아래, 우좌

	static boolean[][] visited;
	static Deque<int[]> originCloud = new ArrayDeque<>();
	static Deque<int[]> movedCloud = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		input();
		originCloud.add(new int[] { N - 1, 0 });
		originCloud.add(new int[] { N - 1, 1 });
		originCloud.add(new int[] { N - 2, 0 });
		originCloud.add(new int[] { N - 2, 1 });

		for (int i = 0; i < M; i++) {
			move(i);
			waterCopy();
			makeCloud();
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				answer += A[i][j];
		}
		System.out.println(answer);
	}

	private static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		d = new int[M];
		s = new int[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			d[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}

	}

	private static void move(int i) {
		visited = new boolean[N][N];

		while (!originCloud.isEmpty()) {
			int[] result = originCloud.poll();
			int r = result[0];
			int c = result[1];

			int nr = r;
			if (delta[d[i]][0] != 0)
				nr = (r + N + (delta[d[i]][0] * s[i]) % N) % (N);
			
			int nc = c;
			if (delta[d[i]][1] != 0)
				nc = (c + N + (delta[d[i]][1] * s[i]) % N) % (N);

			visited[nr][nc] = true;

			movedCloud.add(new int[] { nr, nc });
			A[nr][nc]++;
		}

	}

	private static void waterCopy() {
		while (!movedCloud.isEmpty()) {
			int[] result = movedCloud.poll();
			int r = result[0];
			int c = result[1];

			for (int i = 2; i < 10; i += 2) {
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];
				if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1)
					continue;

				if (A[nr][nc] > 0)
					A[r][c]++;
			}
		}
	}

	private static void makeCloud() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (A[i][j] >= 2 && !visited[i][j]) {
					originCloud.add(new int[] { i, j });
					A[i][j] -= 2;
				}
			}
		}
	}

}
