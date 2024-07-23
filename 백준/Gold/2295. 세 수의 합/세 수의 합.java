import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] U = new long[N];
        for (int i = 0; i < N; i++) U[i] = Long.parseLong(br.readLine());
        Arrays.sort(U);

        Set<Long> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                set.add(U[i] + U[j]);
            }
        }

        long[] u = set.stream().mapToLong(Long::longValue).sorted().toArray();
        boolean done = false;
        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                int s = 0, e = u.length;
                long compare = U[i] - U[j];

                while (s <= e) {
                    int m = (s+e)/2;

                    if (compare < u[m]) {
                        e = m-1;
                    } else if (compare > u[m]) {
                        s = m+1;
                    } else {
                        done = true;
                        bw.write(Long.toString(U[i]));
                        break;
                    }
                }
                if (done) break;
            }
            if (done) break;
        }

        bw.flush();
        bw.close();
    }
}
