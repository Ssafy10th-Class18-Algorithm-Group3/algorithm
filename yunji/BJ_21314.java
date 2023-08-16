import java.io.*;

public class BJ_21314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String min = "";
        String max = "";
        int temp;

        String[] number = br.readLine().split("");
        temp = 0;
        for (int i = 0; i < number.length; i++) {
            char ch = number[i].charAt(0);

            if (ch == 'M') {
                if (i == number.length - 1) {
                    min += 1;
                    if (temp != 0) {
                        for (int j = 0; j < temp; j++) min += 0;
                    }
                }
                temp++;
            } else if (ch == 'K') {
                if (temp != 0) {
                    min += 1;
                    for (int j = 0; j < temp - 1; j++) min += 0;
                    temp = 0;
                } 
                min += 5;
            }
        }

        temp = 0;
        for (int i = 0; i < number.length; i++) {
            char ch = number[i].charAt(0);

            if (ch == 'M') {
                if (i == number.length - 1) {
                    if (temp != 0) {
                        max += 1;
                        for (int j = 0; j < temp - 1; j++) max += 1;
                    }
                    max += 1;
                }
                temp++;
            } else if (ch == 'K') {
                max += 5;
                if (temp != 0) {
                    for (int j = 0; j < temp; j++) max += 0;
                    temp = 0;
                }
            }
        }

        System.out.println(max);
        System.out.println(min);
    }
}
