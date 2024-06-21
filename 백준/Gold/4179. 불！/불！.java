import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[][] maze = new char[r][c];
        int[][] jt = new int[r][c];
        int[][] ft = new int[r][c];

        Queue<int[]> jqueue = new LinkedList<>();
        Queue<int[]> fqueue = new LinkedList<>();
        int[] mx = {1, -1, 0, 0};
        int[] my = {0, 0, 1, -1};
        int result = 0;

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = input.charAt(j);
                if (maze[i][j] == 'F') {
                    ft[i][j] = 1;
                    fqueue.offer(new int[]{i, j});
                }
                if (maze[i][j] == 'J') {
                    if (i == 0 || i == r-1 || j == 0 || j == c-1) {
                        bw.write("1");
                        bw.flush();
                        bw.close();
                        return;
                    }

                    jt[i][j] = 1;
                    jqueue.offer(new int[]{i, j});
                }
            }
        }

        while (!fqueue.isEmpty()) {
            int[] cur = fqueue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i=0; i<mx.length; i++) {
                int nx = cur[0] + mx[i];
                int ny = cur[1] + my[i];

                if (nx < 0 || nx > r-1 || ny < 0 || ny > c-1) {
                    continue;
                }

                if (maze[nx][ny] != '#' && ft[nx][ny] == 0) {
                    ft[nx][ny] = ft[x][y] + 1;
                    fqueue.offer(new int[] {nx, ny});
                }
            }
        }

        while (!jqueue.isEmpty()) {
            int[] cur = jqueue.poll();
            int x = cur[0];
            int y = cur[1];



            for (int i = 0; i < mx.length; i++) {
                int nx = cur[0] + mx[i];
                int ny = cur[1] + my[i];

                if (nx < 0 || nx > r - 1 || ny < 0 || ny > c - 1) {
                    continue;
                }

                if (maze[nx][ny] == '.' && jt[nx][ny] == 0 && (ft[nx][ny] == 0 || jt[x][y]+1 < ft[nx][ny])) {
                    jt[nx][ny] = jt[x][y] + 1;

                    if (nx == 0 || nx == r-1 || ny == 0 || ny == c-1) {
                        result = jt[nx][ny];
                        jqueue.clear();
                        break;
                    }

                    jqueue.offer(new int[] {nx, ny});
                }
            }
        }

        String str = result == 0 ? "IMPOSSIBLE" : String.valueOf(result);
        bw.write(str);
        bw.flush();
        bw.close();
    }
}