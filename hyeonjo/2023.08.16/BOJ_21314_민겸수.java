import java.util.*;
import java.io.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Deque<Character> stack = new ArrayDeque<Character>();
	
	public static void main(String[] args) throws IOException {
		String input = br.readLine();
		
		System.out.println(getMax(input));
		System.out.println(getMin(input));
	}
	
	public static String getMax(String input) {
		StringBuilder maxS = new StringBuilder();
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if (c == 'M') stack.offerLast(c);
			else {
				maxS.append("5");
				while (!stack.isEmpty()) {
					maxS.append("0");
					stack.pollLast();
				}
			}
		}
		
		while (!stack.isEmpty()) {
			maxS.append("1");
			stack.pollLast();
		}
		
		return maxS.toString();
	}
	
	public static String getMin(String input) {
		StringBuilder minS = new StringBuilder();
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			
			if (c == 'M') stack.offerLast(c);
			else {
				if (!stack.isEmpty()) {
					minS.append("1");
					stack.pollLast();
				}
				while (!stack.isEmpty()) {
					minS.append("0");
					stack.pollLast();
				}
				minS.append("5");
			}
		}
		
		if (!stack.isEmpty()) {
			minS.append("1");
			stack.pollLast();
		}
		while (!stack.isEmpty()) {
			minS.append("0");
			stack.pollLast();
		}
		return minS.toString();
	}
}
