import java.io.*;

public class Main {
    public static int step;
    public static int[] dp;
    public static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        step = Integer.parseInt(br.readLine());
        dp = new int[step+1];
        score = new int[step+1];

        for (int i=1; i<=step; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = score[1];

        if (step >= 2) {
            dp[2] = score[1] + score[2];
            recur(3);
        }

        bw.write(Integer.toString(dp[step]));
        bw.flush();
        bw.close();
    }

    public static void recur(int tmp) {
        if (tmp <= step) {
            dp[tmp] += Math.max(dp[tmp-2], dp[tmp-3] + score[tmp-1]) + score[tmp];
            recur(tmp+1);
        }
    }
}
