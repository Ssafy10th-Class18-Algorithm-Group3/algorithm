import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int min = Integer.MAX_VALUE;
	static int A, B;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(stk.nextToken());
		B = Integer.parseInt(stk.nextToken());
		
		DFS(1, A);
		
		if (min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	}
	
	public static void DFS(int L, int N) {
		if (N > B) return;
		if (N == B) min = Math.min(min, L);
		
		DFS(L + 1, 2 * N);
		DFS(L + 1, 10 * N + 1);
	}
}
