import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] str = new int[] {-1, 0, 1, 1, 0};
		long k = Long.parseLong(br.readLine());

		long binary = 1;
		long cnt = 0;
		while (true) {
			if (k < 4) break;
			if (k <= binary) {
				binary /= 2;
				k = k-binary;
				binary = 1;
				cnt += 1;
			}
			binary *= 2;
		}
		
		if (cnt % 2 == 1) System.out.println(Math.abs(str[(int)k]-1));
		else System.out.println(str[(int)k]);
			
	}

}
