import java.io.*;
import java.util.*;


public class Main{
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        String[] value = br.readLine().split("");
        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();
        
        // 최대
        int cnt = 0;
        for (int i=0; i<value.length; i++) {
        	if (value[i].contains("M")) cnt += 1;
        	else {
        		max.append("5");
        		for (int c=0; c<cnt; c++) max.append("0");
        		cnt = 0;
        	}
        }
        
        if (cnt > 0) {
        	cnt -= 1;
        	max.append("1");
        	while (cnt > 0) {
        		max.append("1");
        		cnt -= 1;
        	}
        }
        
        // 최소
        cnt = 0;
        for (int i=0; i<value.length; i++) {
        	if (value[i].contains("M")) {
        		cnt += 1;
        	}
        	else {
        		if (cnt>0) {
            		min.append("1");
            		for (int c=1; c<cnt; c++) min.append("0");
            		cnt = 0;
        		}
        		min.append("5");
        	}
        }
        
        if (cnt > 0) {
        	cnt -= 1;
        	min.append("1");
        	while (cnt > 0) {
        		min.append("0");
        		cnt -= 1;
        	}
        }
        
        System.out.println(max);
        System.out.println(min);
        
    } 
}