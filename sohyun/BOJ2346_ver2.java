import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2346_ver2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Deque<int[]> dq = new ArrayDeque<int[]>();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			int n = Integer.parseInt(st.nextToken());
			dq.addLast(new int[] {n,i});
		}
		
		int cnt =dq.pollFirst()[0];
		System.out.print("1 ");
		
		while(!dq.isEmpty()) {
			
			if(cnt>0) {
				cnt--;
				
				while(cnt>0) {
					dq.addLast(dq.pollFirst());
					cnt--;
				}
				
			}else {
				while(cnt<0) {
					dq.addFirst(dq.pollLast());
					cnt++;
				}
			}
			
			
			cnt = dq.peekFirst()[0];
			System.out.print(dq.pollFirst()[1]+" ");
		}
	}

}
