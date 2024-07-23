import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] X = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        int[] x = Arrays.stream(X).sorted().distinct().toArray();

        for (int i = 0; i < N; i++) {
            int s = 0, e = x.length-1, res = 0;

            while (s <= e) {
                int m = (s+e)/2;

                if (X[i] < x[m]) {
                    e = m-1;
                } else if (X[i] > x[m]) {
                    s = m+1;
                } else {
                    res = m;
                    break;
                }
            }

            bw.write(res + " ");
        }

        bw.flush();
        bw.close();
    }
}
