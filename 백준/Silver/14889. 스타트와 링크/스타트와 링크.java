import java.io.*;
import java.util.*;

public class Main {
    public static BufferedWriter bw;
    public static int N;
    public static int[][] S;
    public static boolean[] used;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        used = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        back(0, 0);

        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
    }

    public static void back(int idx, int cnt) {
        if (cnt == N/2) {
            int a = 0;
            int b = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    if (used[i] && used[j]) {
                        a += (S[i][j] + S[j][i]);
                    } else if (!used[i] && !used[j]) {
                        b += (S[i][j] + S[j][i]);
                    }
                }
            }

            min = Math.min(min, Math.abs(a - b));
        } else {
            for (int i = idx; i < N; i++) {
                if (!used[i]) {
                    used[i] = true;
                    back(i, cnt+1);
                    used[i] = false;
                }
            }
        }
    }
}

