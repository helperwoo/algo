import java.io.*;
import java.util.*;

public class Main {
    private static int order = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        recur(N, r, c);
        bw.write(Integer.toString(order));
        bw.flush();
        bw.close();
    }

    public static void recur(int N, int r, int c) {
        if (N == 0) return;

        int size = (int) (Math.pow(2, N-1));
        int area = size * size;

        if (r >= size && c >= size) {
            order += area * 3;
            r -= size;
            c -= size;
        } else if (r < size && c >= size) {
            order += area;
            c -= size;
        } else if (r >= size && c < size) {
            order += area * 2;
            r -= size;
        }

        recur(N - 1, r, c);
    }
}