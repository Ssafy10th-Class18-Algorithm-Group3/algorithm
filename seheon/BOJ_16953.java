import java.io.*;
import java.util.*;


public class Main{
    
	static int[] arr = new int[9];
	static List<Integer> P = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        String b = st.nextToken();
        sb.append(String.valueOf(b));
        
        int ans = -1;
        int cnt = 0;
        while (true) {
        	if (Integer.parseInt(b) == a) {
        		ans = cnt;
        		break;
        	}
        	if (Integer.parseInt(b) < a) break;
        	if (b.charAt(b.length()-1) == '1') b = b.substring(0, b.length()-1);
        	else if (Integer.parseInt(b)%2 == 1 && b.charAt(b.length()-1) != '1') break;
        	else b = String.valueOf(Integer.parseInt(b)/2);
        	cnt += 1;
        }
        if (ans == -1) System.out.println(-1);
        else System.out.println(ans+1);
    }
}