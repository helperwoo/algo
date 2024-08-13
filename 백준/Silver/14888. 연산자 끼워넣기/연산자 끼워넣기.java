import java.io.*;
import java.util.*;

public class Main {
    public static BufferedWriter bw;
    public static int N;
    public static int[] arr;
    public static int[] calc;
    public static boolean[] used;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        calc = new int[N - 1];
        used = new boolean[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int type = i == 0 ? 0
                    : i == 1 ? 1
                    : i == 2 ? 2 : 3;
            int times = Integer.parseInt(st.nextToken());

            for (int j = 0; j < times; j++) {
                calc[cnt++] = type;
            }
        }

        back(arr[0], 0);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
    }

    public static void back(int result, int cnt) {
        if (cnt == (N - 1)) {
            max = Math.max(max, result);
            min = Math.min(min, result);
        } else {
            for (int i = 0; i < calc.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    int tmp = calc[i] == 0 ? result + arr[cnt+1]
                            : calc[i] == 1 ? result - arr[cnt+1]
                            : calc[i] == 2 ? result * arr[cnt+1]
                            : result / arr[cnt+1];
                    back(tmp, cnt+1);
                    used[i] = false;
                }
            }
        }
    }
}

