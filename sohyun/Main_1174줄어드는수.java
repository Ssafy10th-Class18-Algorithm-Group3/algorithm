import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1174줄어드는수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static List<Long> answer;
	static int[] num = {9,8,7,6,5,4,3,2,1,0};
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		answer = new ArrayList<Long>();
		dfs(0, 0);
		answer.sort(null);
		try {
			System.out.println(answer.get(N-1));
			
		}catch(Exception e) {
			System.out.println(-1);
		}
	}
	public static void dfs(long n,int i) {
		if(!answer.contains(n)) answer.add(n);
		
		if(i==10) return;
		
		dfs(n*10+num[i],i+1);
		dfs(n,i+1);
		
	}

}
