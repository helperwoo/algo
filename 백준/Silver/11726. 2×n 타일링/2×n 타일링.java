import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        if (n >= 4) {
            for (int i=4; i<=n; i++) {
                dp[i] = (dp[i-2] + dp[i-1]) % 10007;
            }
        }

        bw.write(Integer.toString(dp[n]));
        bw.flush();
        bw.close();
    }
}
