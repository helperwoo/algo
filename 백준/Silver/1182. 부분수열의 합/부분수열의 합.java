import java.io.*;
import java.util.*;

public class Main {
    private static int N, S;
    private static int count = 0;
    private static int[] arr;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        used = new boolean[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        back(0, 0);
        if (S == 0) count--;
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

    public static void back(int cur, int sum) {
        if (sum == S) {
            count++;
        }

        for (int i=cur; i<N; i++) {
            if (!used[i]) {
                used[i] = true;
                back(i, sum+arr[i]);
                used[i] = false;
            }
        }
    }
}