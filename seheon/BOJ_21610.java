import java.io.*;
import java.security.KeyStore.Entry;
import java.util.*;

class Matrix{
	int x;
	int y;
	
	public Matrix(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	
}


public class Main {
	
	static int n;
	static int d;
	static int s;
	static int[][] M;
	static int[][] dis;
	static List<Integer[]> C;
	static int[][] dxy = {{}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		M = new int[n][n];
		C = new ArrayList<>();
		C.add(new Integer[] {0, n-1});
		C.add(new Integer[] {1, n-1});
		C.add(new Integer[] {0, n-2});
		C.add(new Integer[] {1, n-2});
		
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int idx=0;
			while (st.hasMoreTokens()) {
				M[i][idx++] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			one();
			twoThreeFour();
			five();
				
		}
		
		int ans = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				ans += M[i][j];
			}
		}
		
		System.out.println(ans);

	}
	
	static void one() {
		int idx = 0;
		for (Integer[] c : C) {
			int x = c[0];
			int y = c[1];
			for (int i=0; i<s; i++) {
				x += dxy[d][0];
				y += dxy[d][1];
				if (x>n-1) x=0;
				else if (x<0) x=n-1;
				
				if (y>n-1) y=0;
				else if (y<0) y=n-1;
			}
			C.get(idx)[0] = x;
			C.get(idx++)[1] = y;
		}
	} 
	
	static void twoThreeFour(){
		dis = new int[n][n];
		Map<Matrix, Integer> temp = new HashMap<>();
		for (Integer[] c : C) {
			int x = c[0];
			int y = c[1];
			
			Matrix matrix = new Matrix(x, y);
			temp.put(matrix, 0);
			
			M[y][x] += 1;
			dis[y][x] = 1;
			
		}
		
		for (Integer[] c : C) {
			int x = c[0];
			int y = c[1];
			
			if (x+1<=n-1 && y+1<=n-1 && M[y+1][x+1] > 0) temp.put(new Matrix(x, y), temp.get(new Matrix(x, y))+1);
			if (x+1<=n-1 && y-1>=0 && M[y-1][x+1] > 0) temp.put(new Matrix(x, y), temp.get(new Matrix(x, y))+1);
			if (x-1>=0 && y+1<=n-1 && M[y+1][x-1] > 0) temp.put(new Matrix(x, y), temp.get(new Matrix(x, y))+1);
			if (x-1>=0 && y-1>=0 && M[y-1][x-1] > 0) temp.put(new Matrix(x, y), temp.get(new Matrix(x, y))+1);;
			
		}
		
		for (Map.Entry<Matrix, Integer> e : temp.entrySet()) {
			M[e.getKey().y][e.getKey().x] += e.getValue();
		}
		
		
		C = new ArrayList<>();
	}
	
	
	static void five(){
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (M[i][j]>=2 && dis[i][j]==0) {
					C.add(new Integer[] {j, i});
					M[i][j] -= 2;
				}
			}
		}
	}
	
}
