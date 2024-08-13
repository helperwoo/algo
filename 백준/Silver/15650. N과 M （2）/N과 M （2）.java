import java.io.*;
import java.util.*;

public class Main {
    public static BufferedWriter bw;
    public static int N;
    public static int M;
    public static int[] arr;
    public static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        used = new boolean[N];

        for (int i = 0; i < N; i++) arr[i] = i+1;

        String result;
        for (int i=0; i<N; i++) {
         result = Integer.toString(arr[i]);
            used[i] = true;
            back(i, result);
            used[i] = false;
        }

        bw.flush();
        bw.close();
    }

    public static void back(int idx, String result) throws IOException {
        if (result.split(" ").length == M) {
            bw.write(result + "\n");
        } else {
            for (int i=idx+1; i<N; i++) {
                if (!used[i]) {
                    used[i] = true;
                    back(i, result + " " + arr[i]);
                    used[i] = false;
                }
            }
        }
    }
}

