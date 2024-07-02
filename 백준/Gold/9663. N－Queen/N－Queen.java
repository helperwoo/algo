import java.io.*;
import java.util.*;

public class Main {
    private static int count = 0;
    private static int n;
    private static int[] y;
    private static int[] xy;
    private static int[] yx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        y = new int[n];
        xy = new int[2*n];
        yx = new int[2*n];

        back(0);
        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }

    public static void back(int r) {
        if (r == n) {
            count++;
        } else {
            for (int i=0; i<n; i++) {
                if (y[i] == 0 && xy[r+i] == 0 && yx[n-1+r-i] == 0) {
                    y[i] = 1;
                    xy[r+i] = 1;
                    yx[n-1+r-i] = 1;
                    back(r+1);
                    y[i] = 0;
                    xy[r+i] = 0;
                    yx[n-1+r-i] = 0;
                }
            }
        }
    }
}