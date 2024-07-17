import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] log = new int[N+1];

        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1]+1;
            log[i] = i-1;

            if (i%2==0 && dp[i] > dp[i/2]+1) {
                dp[i] = dp[i/2]+1;
                log[i] = i/2;
            }

            if (i%3==0 && dp[i] > dp[i/3]+1) {
                dp[i] = dp[i/3]+1;
                log[i] = i/3;
            }
        }

        bw.write(dp[N] + "\n");

        while (N>0) {
            bw.write(N + " ");
            N = log[N];
        }

        bw.flush();
        bw.close();
    }
}
