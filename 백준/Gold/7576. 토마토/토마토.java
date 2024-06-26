import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] tmt = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        int doneCnt = 0;
        int waitCnt = 0;
        int noneCnt = 0;

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                tmt[j][i] = Integer.parseInt(st.nextToken());
                if (tmt[j][i] == -1) {
                    noneCnt++;
                } else if (tmt[j][i] == 0) {
                    waitCnt++;
                } else if (tmt[j][i] == 1) {
                    doneCnt++;
                    queue.offer(new int[] {j, i, 0});
                }
            }
        }
        int days = 0;

        if ((noneCnt+doneCnt) == (n*m)) {
            bw.write(Integer.toString(0));
        } else if ((noneCnt+waitCnt) == (n*m)) {
            bw.write(Integer.toString(-1));
        } else {
            int[] mx = new int[] {1, -1, 0, 0};
            int[] my = new int[] {0, 0, 1, -1};

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int cx = cur[0];
                int cy = cur[1];
                int day = cur[2];
                days = day;

                for (int i=0; i<mx.length; i++) {
                    int nx = cx + mx[i];
                    int ny = cy + my[i];

                    if (nx<0 || nx>n-1 || ny<0 || ny>m-1) {
                        continue;
                    }

                    if (!visit[nx][ny] && tmt[nx][ny] == 0) {
                        queue.offer(new int[] {nx, ny, day+1});
                        tmt[nx][ny] = 1;
                        doneCnt++;
                        waitCnt--;
                        visit[nx][ny] = true;
                    }
                }
            }

            if (waitCnt > 0) {
                bw.write(Integer.toString(-1));
            } else {
                bw.write(Integer.toString(days));
            }
        }

        bw.flush();
        bw.close();
    }
}