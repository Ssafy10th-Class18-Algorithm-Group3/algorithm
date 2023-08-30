import java.util.*;
import java.io.*;


public class Main {

    static int[] M;
    static LinkedList<Integer> Belt1 = new LinkedList<>();
    static LinkedList<Integer> Belt2 = new LinkedList<>();
    static LinkedList<Integer> Robot = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        M = new int[2*n];
        for (int i=0; i<n; i++) Robot.add(0);


        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            M[idx++] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++) Belt1.add(M[i]);
        for (int i=n; i<2*n; i++) Belt2.add(M[i]);

        int ans = 1;
        int zero = 0;
        while (true){
            // 1
            Belt1.addFirst(Belt2.pollLast());
            Belt2.addFirst(Belt1.pollLast());
            
            Robot.pollLast();
            Robot.addFirst(0);
            if (Robot.get(n-1) > 0) Robot.set(n-1, 0);
            
            // 2
            for (int i=n-1; i>-1; i--) {
            	if (Robot.get(i) > 0 && Robot.get(i+1) == 0 && Belt1.get(i+1)>0) {
            		Robot.set(i+1, Robot.get(i));
            		Robot.set(i, 0);
            		if (Robot.get(n-1) > 0) Robot.set(n-1, 0);
            		Belt1.set(i+1, Belt1.get(i+1)-1);
                    if (Belt1.get(i+1) == 0) zero += 1;
            	}
            }
          
            
            // 3
            if (Belt1.peekFirst() != 0) {
            	Belt1.set(0, Belt1.get(0)-1);
            	if (Belt1.get(0) == 0) zero += 1;
            	Robot.set(0, 1);
            }

            // 4
            if (zero >= k) break;
            ans += 1;
            
            for (int i=0; i<n; i++){
                if (Robot.get(i) > 0) Robot.set(i, Robot.get(i)+1);
            }
            
        }
        System.out.println(ans);
    }

}
