import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dp = new int[list.size()];

        int max = 0;

        // Bottom-Top
        max = loop();
        
        // Top-Bottom
        max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, recursive(i));
        }
        
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    static int recursive(int idx) {
        if (dp[idx] == 0) {
            dp[idx] = 1;

            for (int i = 0; i < idx; i++) {
                if (list.get(i) < list.get(idx)) {
                    dp[idx] = Math.max(dp[idx], recursive(i) + 1);
                }
            }
        }

        return dp[idx];
    }

    static int loop() {
        for (int i = 0; i < list.size(); i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (list.get(j) < list.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return Arrays.stream(dp).max().orElseThrow();
    }
}