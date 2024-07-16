import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];

        if (2 <= N) {
            dp[2] = dp[3] = 1;

            for (int i=4; i<=N; i++) {
                dp[i] = dp[i-1] + 1;
                if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
                if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }

        bw.write(Integer.toString(dp[N]));
        bw.flush();
        bw.close();
    }
}
