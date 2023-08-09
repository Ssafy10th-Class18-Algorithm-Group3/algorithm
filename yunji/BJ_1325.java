import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1325 {

    static ArrayList<ArrayList<Integer>> graph;
    static int N, M;
    static boolean visit[];
    static int count[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder prt = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(B).add(A);
        }

        int max = 0;
        count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            bfs(i);
            max = Math.max(count[i], max);
        }

        for (int i = 1; i <= N; i++) {
            if (count[i] == max) {
                prt.append(i).append(" ");
            }
        }
        bw.write(prt.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visit[start] = true;

        while (!q.isEmpty()) {
            int idx = q.poll();
            for (int next : graph.get(idx)) {
                if (!visit[next]) {
                    visit[next] = true;
                    q.add(next);
                    count[start]++;
                }
            }
        }
    }
}