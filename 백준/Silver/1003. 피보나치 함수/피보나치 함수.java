import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];

        dp[0] = new int[] {1, 0};
        dp[1] = new int[] {0, 1};
        dp[2] = new int[] {1, 1};

        for (int i=3; i<41; i++) {
            dp[i] = new int[] {dp[i-1][0] + dp[i-2][0], dp[i-1][1] + dp[i-2][1]};
        }

        for (int i=0; i<T; i++) {
            int tmp = Integer.parseInt(br.readLine());
            bw.write(dp[tmp][0] + " " + dp[tmp][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
