import java.io.*;

public class Main {
    public static int N;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<N+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        bw.write(Integer.toString(dp[N]));
        bw.flush();
        bw.close();
    }
}
