import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_20055컨베이어벨트위의로봇 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, K, answer = 1;
	static int cnt[];
	static boolean[] robots;

	public static void main(String[] args) throws Exception {
		input();
		solve();
		System.out.println(answer);
	}

	private static void input() throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		cnt = new int[N * 2];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N * 2; i++)
			cnt[i] = Integer.parseInt(st.nextToken());

		robots = new boolean[N];
	}

	private static void solve() {
		while (true) {
			// 1. 회전
			// 1) 컨테이너 회전
			int buffer = cnt[N * 2 - 1];
			for (int i = N * 2 - 1; i > 0; i--) {
				cnt[i] = cnt[i - 1];
			}
			cnt[0] = buffer;

			// 2) 로봇 회전
			for (int i = N - 2; i > 0; i--) {
				robots[i] = robots[i - 1];
			}
			robots[0] = false;
			robots[N - 1] = false; // 내리는 위치, 무조건 로봇 없어지니까

			// 2. 로봇 이동
			for (int i = N - 2; i > 0; i--) {
				if (robots[i] && !robots[i + 1] && cnt[i + 1] >= 1) {
					robots[i + 1] = robots[i];
					cnt[i + 1]--;
					
					robots[i] = false;

					if (i + 1 == N - 1) // 내리는 위치면
						robots[i + 1] = false;
				}
			}

			// 3. 올리는 위치 내구도 확인 후, 로봇 올리기
			if (cnt[0] >= 1) {
				cnt[0]--;
				robots[0] = true;
			}

			// 4. 기저조건 확인
			if (countZero() >= K)
				break;
			answer++;

		}
	}

	private static int countZero() {
		int result = 0;
		for (int i = 0; i < 2 * N; i++)
			if (cnt[i] == 0) result++;
		return result;
	}

	private static void print() {
		System.out.println(Arrays.toString(cnt));
		System.out.println(Arrays.toString(robots));
		System.out.println();
	}

}
