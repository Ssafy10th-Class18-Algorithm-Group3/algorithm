import java.io.*;
import java.util.*;

public class BJ_20055 {
    static int[] durability;
    static int[] belt;
    static int first, cnt;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        durability = new int[N * 2];
        belt = new int[N];
        for (int i = 0; i < 2 * N; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        first = 0;
        cnt = 0;
        move();
    }

    private static void move() {
        int step = 0;

        while (true) {
            step++;

            //1. 벨트 한칸 회전
            if (--first < 0) first = 2 * N + first;
            beltCycle();

            //2. 옮길 수 있으면 로봇 옮기기
            belt[N - 1] = 0;
            for (int i = N - 1; i >= 1; i--) {
                if (belt[i] == 0 && belt[i - 1] == 1) {
                    if (durability[(first + i) % (2 * N)] > 0) {
                        durability[(first + i) % (2 * N)]--;
                        if (durability[(first + i) % (2 * N)] == 0) cnt++;
                        belt[i] = 1;
                        belt[i - 1] = 0;
                    }     
                }
            }
            //3. 올리는 위치에 로봇 올리기
            if (durability[first] > 0) {
                belt[0] = 1;
                if (--durability[first] == 0) cnt++;
            }

            //4. 내구도 0인 칸 개수 체크
            if (cnt >= K) break;
        }

        System.out.println(step);
    }

    private static void beltCycle() {

        for (int i = N - 2; i >= 0; i--) {
            belt[i + 1] = belt[i];
        }
        belt[0] = 0;
    }
}