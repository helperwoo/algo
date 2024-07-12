import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0;
        int b = 0;
        int length = Integer.MAX_VALUE;
        int sum = arr[a];

        while (a <= b && b < N) {
            if (sum < S) {
                b++;
                if (b < N) sum += arr[b];
            } else {
                length = Math.min(length, b - a + 1);
                sum -= arr[a];
                a++;
            }
        }

        if (length == Integer.MAX_VALUE) length = 0;
        bw.write(Integer.toString(length));
        bw.flush();
        bw.close();
    }
}
