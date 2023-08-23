import java.util.*;
import java.io.*;

public class Main {
	
	static int[] two = {10, 20, 21, 30, 31, 32, 40, 41, 42, 43, 50, 51, 52, 53, 54, 60, 61, 62, 63, 64, 65, 70, 71, 72, 73, 74, 75, 76, 80, 81, 82, 83, 84, 85, 86, 87, 90, 91, 92, 93, 94, 95, 96, 97, 98};
	
	static List<StringBuilder> M = new ArrayList<>();
	static List<StringBuilder> temp = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int k = Integer.parseInt(st.nextToken());
		
		for (int t : two) {
			sb.append(t);
			M.add(sb);
			sb = new StringBuilder();
		}
	
		
		if (k<=10) System.out.println(k-1);
		else if(k<=55) System.out.println(M.get(k-11));
		else {
			int cnt = 55;
			int idx = 0;
			int front = 1; 
			while (true) {
				if (k == cnt) {
					System.out.println(sb.toString());
					break;
				}
				
				if (idx > M.size()-1 || front > 9) {
					M = new ArrayList<>();
					front = 1;
					idx = 0;
					M.addAll(temp);
					temp = new ArrayList<>();
				}
				
				if (sb.toString().equals("9876543210")) {
					System.out.println(-1);
					break;
				}
				
				if (Character.getNumericValue(M.get(idx).charAt(0)) >= front) {
                    idx = 0;
					front += 1;
					continue;
				}
				
				sb = new StringBuilder();
				
				sb.append(front);
				sb.append(M.get(idx));
				temp.add(sb);
				idx += 1;
				cnt += 1;
				
			}
		}
		
	}

}
