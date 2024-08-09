import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int[][] A;
    static int[][] rotate;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(tmp[j]);
                A[i][j] = a;
            }
        }

        rotate = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            rotate[i] = new int[] {r, c, s};
        }

        dfs(0, new int[K], new boolean[K]);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }

    public static void dfs(int cnt, int[] order, boolean[] used) {
        if (cnt == K) {
            int[][] tmp = new int[N][M];
            for (int i = 0; i < N; i++) {
                tmp[i] = A[i].clone();
            }

            for (int i = 0; i < K; i++) {
                int[] calc = rotate[order[i]];
                int[] start = new int[] {calc[0] - 1 - calc[2], calc[1] - 1 - calc[2]};
                int[] end = new int[] {calc[0] - 1 + calc[2], calc[1] - 1 + calc[2] };

                tmp = recur(tmp, start, end);
            }

            for (int j = 0; j < N; j++) {
                result = Math.min(result, Arrays.stream(tmp[j]).sum());
            }
        } else {
            for (int i = 0; i < K; i++) {
                if (!used[i]) {
                    used[i] = true;
                    order[cnt] = i;
                    dfs(cnt+1, order, used);
                    used[i] = false;
                }
            }
        }
    }

    public static int[][] recur(int[][] map, int[] start, int[] end) {
        int row = start[0];
        int col = start[1]+1;
        int mem = map[start[0]][start[1]];

        while (true) {
            int tmp = map[row][col];
            map[row][col] = mem;
            mem = tmp;

            if (row == start[0]) {
                if (col == end[1]) row++;
                else col++;
            } else if (row == end[0]) {
                if (col == start[1]) row--;
                else col--;
            } else {
                if (col == start[1]) row--;
                else row++;
            }

            if (row == start[0] && col == start[1]+1) break;
        }

        if (start[0] + 1 < (start[0] + end[0]) / 2) {
            start[0]++;
            start[1]++;
            end[0]--;
            end[1]--;
            map = recur(map, start, end);
        }

        return map;
    }
}

