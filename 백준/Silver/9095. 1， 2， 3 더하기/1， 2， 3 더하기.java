import java.io.*;

public class Main {
    public static int T;
    public static int[] arr;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        arr = new int[T];
        dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i=4; i<12; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i=0; i<T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            bw.write(dp[arr[i]]+ "\n");
        }

        bw.flush();
        bw.close();
    }
}
