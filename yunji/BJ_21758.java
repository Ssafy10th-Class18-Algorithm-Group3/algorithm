import java.io.*;
import java.util.*;

public class BJ_21758 {
    static int N;
    static int honey[];
    static int sum[];
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        honey = new int[N + 1];
        sum = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            sum[i] = honey[i] + sum[i - 1];
        }

        findMaximunHoney();
        System.out.println(max);
    }

    private static void findMaximunHoney() {
        int total;
        
        for (int i = 2; i < N; i++) {
            total = sum[N] * 2 - (sum[i] + honey[i] + honey[1]);
            max = Math.max(max, total);
        }

        for (int i = 2; i < N; i++) {
            total = sum[N] + sum[i - 1] - (honey[N] + honey[i]);
            max = Math.max(max, total);
        }

        for (int i = 2; i < N; i++) {
            total = sum[N] - sum[i - 1] + sum[i] - (honey[1] + honey[N]);
            max = Math.max(max, total);
        }
    }
}
