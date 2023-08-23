import java.util.*;
import java.io.*;

public class Main {

	static int[] M;
	static int[] C1;
	static int[] C2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		M = new int[n];
	
		
		st = new StringTokenizer(br.readLine());
		
		int idx = 0;
		while (st.hasMoreTokens()) {
			M[idx++] = Integer.parseInt(st.nextToken());
		}
		
		C1 = Arrays.copyOf(M, M.length);
		C2 = Arrays.copyOf(M, M.length);
		
		for (int i=1; i<n; i++) {
			C1[i] = C1[i-1] + C1[i];
		}
		
		for (int i=n-2; i>-1; i--) {
			C2[i] = C2[i+1] + C2[i];
		}
		
		
		int ans = 0;
		// 벌벌꿀
		int l = 0;
		int r = 1;
		while (true) {
			if (r == n-1) break;
			ans = Math.max(ans, (C1[n-1]-C1[l]-M[r])+(C1[n-1]-C1[r]));
			r += 1;
		}
		
		// 꿀벌벌
		l = n-2;
		r = n-1;
		while (true) {
			if (l == 0) break;
			ans = Math.max(ans, (C2[0]-C2[r]-M[l])+(C2[0]-C2[l]));
			l -= 1;
		}
		
		// 벌꿀벌
		int m = n/2;
		l = 0;
		r = n-1;
		ans = Math.max(ans, (C1[m]-C1[l])+(C2[m]-C2[r]));
		
		System.out.println(ans);
	}
}
