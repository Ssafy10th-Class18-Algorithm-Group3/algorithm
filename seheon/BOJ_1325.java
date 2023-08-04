import java.io.*;
import java.util.*;

public class Main {

	static List<List<Integer>> M = new ArrayList<>(); 
	static Queue<Integer> Q = new LinkedList<>();
	static int[] count;
	static int[] visited;
	static int cnt = 0;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	String[] info = br.readLine().split(" ");
    	int n = Integer.parseInt(info[0]), m = Integer.parseInt(info[1]);
    	count = new int[n+1];
    	
    	for (int i=0; i<=n; i++) {
    		M.add(new ArrayList<>());
    	}
    	
    	for (int i=0; i<m; i++) {
    		String[] nodes = br.readLine().split(" ");
    		int node1 = Integer.parseInt(nodes[0]), node2 = Integer.parseInt(nodes[1]);
    		M.get(node2).add(node1);
    	}
    	
    	
    	for (int i=1; i<=n; i++) {
    		visited = new int[n+1];
    		visited[i] = 1;
    		cnt = 0;
    		Q.add(new Integer(i));
    		while (!Q.isEmpty()) {
    			int parent = Q.poll();
    			for (int child : M.get(parent)) {
    				if (visited[child] == 1) continue;
    				visited[child] = 1;
    				cnt += 1;
    				Q.add(child);
    			}
    		}
    		count[i] = cnt;
    	}
    
    	
    	int max=0;
    	for (int c : count) {
			max = Math.max(max, c);
		}
    	
    	for (int i=1; i<=n; i++) {
			if (count[i] == max) System.out.print(i + " ");
		}
    	
    }

}
