package BOJ;

import java.io.*;

public class BOJ_18222_투에모스_문자열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k = 1;

    public static void main(String[] args) throws IOException {
        DFS(Long.parseLong(br.readLine()) - 1);
    }

    public static void DFS(long n) {
        if (n <= 1) {
            if (n == 0) k = (k + 1) % 2;
            System.out.println(k);
            return;
        }

        for (int i = 1; i <= 60; i++) {
            if (n < Math.pow(2, i)) {
                n -= (long)Math.pow(2, i - 1);
                break;
            }
        }
        k = (k + 1) % 2;
        DFS(n);
    }
}
/*
01101001 10 0 1 0 1 1 0
01234567 89101112131415
 */