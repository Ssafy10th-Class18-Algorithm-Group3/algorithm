package algo;

import java.io.*;
import java.util.*;

public class Main {

	static List<List<Integer>> M = new ArrayList<>(); 
	static Queue<Integer> Q = new LinkedList<>();
	static int[] visited;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	int n = Integer.parseInt(br.readLine());
    	int m = Integer.parseInt(br.readLine());
    	
    	for (int i=0; i<=n+1; i++) {
    		M.add(new ArrayList<Integer>());
    	}
    	visited = new int[n+1];
    	
    	for (int i=0; i<m; i++) {
    		String[] info = br.readLine().split(" ");
    		int s = Integer.parseInt(info[0]), e = Integer.parseInt(info[1]);
    		M.get(s).add(e);
    		M.get(e).add(s);
    	}
    	
    	Q.add(1);
    	visited[1] = 1;
    	int cnt = 0;
    	while (!Q.isEmpty()) {
    		int node = Q.poll();
    		for (Integer target : M.get(node)) {
    			if (visited[target] == 1) continue;
    			visited[target] = 1;
    			cnt += 1;
    			Q.add(target);
    		}
    	}
    	
    	System.out.println(cnt);
    	
    }

}

