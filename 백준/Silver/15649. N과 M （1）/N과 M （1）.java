import java.io.*;
import java.util.*;

public class Main {
    private static StringBuffer sb = new StringBuffer();
    private static int n, m;
    private static int[] arr;
    private static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        used = new boolean[n+1];

        back(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void back(int k) {
        if (k < m) {
            for (int i=1; i<=n; i++) {
                if (!used[i]) {
                    used[i] = true;
                    arr[k] = i;
                    back(k+1);
                    used[i] = false;
                }
            }
        } else {
            for(int i=0; i<m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
        }

    }
}