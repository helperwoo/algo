import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] prime = new boolean[N+1];
        prime[0] = prime[1] = true;

        if (N > 1) {
            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (prime[i]) continue;

                for (int j = i * i; j <= N; j += i) {
                    prime[j] = true;
                }
            }

            for (int i = M; i <= N; i++) {
                if (!prime[i]) bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}

