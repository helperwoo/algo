import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        arr = new int[size][size];
        dp = new int[size][size];

        for (int i = 0; i < size; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            int j = 0;
            while (st.hasMoreTokens()) {
                arr[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0) {
                    dp[i][j] = arr[i][j];
                    continue;
                }

                dp[i][j] = (j == 0)
                        ? dp[i-1][j] + arr[i][j]
                        : Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }
        int max = Arrays.stream(dp[dp.length - 1]).max().orElseThrow();

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}