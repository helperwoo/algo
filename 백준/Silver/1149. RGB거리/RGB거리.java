import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];
        int[][] price = new int[N+1][3];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0] = price[1][0];
        dp[1][1] = price[1][1];
        dp[1][2] = price[1][2];

        for (int i=2; i<=N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + price[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + price[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + price[i][2];
        }

        bw.write(Integer.toString(Arrays.stream(dp[N]).min().getAsInt()));

        bw.flush();
        bw.close();
    }
}
