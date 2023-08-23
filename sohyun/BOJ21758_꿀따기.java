import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ21758_꿀따기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int nums[], sums[];
	static int bucket[];
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		sums = new int[N];
		bucket = new int[2];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			sum += nums[i];
			sums[i] = sum;
		}

		// 벌벌꿀
		bucket[0] = 0;
		for(int i=1;i<N-1;i++) {
			bucket[1] = i;
			answer = Math.max(answer, getDist(N-1, bucket));
		}
		
		// 꿀벌벌
		bucket[1] = N-1;
		for(int i=1;i<N-1;i++) {
			bucket[0]=i;
			answer = Math.max(answer, getDist(0,bucket));
		}
		
		bucket[0]=0;
		bucket[1] = N-1;
		for(int i=1;i<N-1;i++) {
			answer = Math.max(answer, getDist(i,bucket));
		}
		
		System.out.println(answer);

	}

	private static int getDist(int honey, int[] bee) {
		int sum = 0;
		for (int i = 0; i < 2; i++) {
			if (bee[i] < honey)
				sum += sums[honey] - sums[bee[i]];
			else
				sum += sums[bee[i] - 1] - sums[honey] + nums[honey];
		}

		if (bee[1] < honey)
			sum -= nums[bee[1]];
		if (bee[0] > honey)
			sum -= nums[bee[0]];
		return sum;
	}

}
