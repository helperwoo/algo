import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[m][n];
        int[][] visited = new int[m][n];
        visited[0][0] = 1;

        for (int i=0; i<n; i++) {
            int[] row = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j=0; j<m; j++) {
                map[j][i] = row[j];
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int[] moveX = new int[] {1, -1, 0, 0};
        int[] moveY = new int[] {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == m-1 && cur[1] == n-1) {
                bw.write(String.valueOf(visited[m-1][n-1]));
                queue.clear();
                break;
            }

            for (int i=0; i<moveX.length; i++) {
                int nX = cur[0] + moveX[i];
                int nY = cur[1] + moveY[i];

                if (nX < 0 || nY < 0 || nX > m-1 || nY > n-1) {
                    continue;
                }

                if (visited[nX][nY] == 0 && map[nX][nY] == 1) {
                    visited[nX][nY] = visited[cur[0]][cur[1]]+1;
                    queue.offer(new int[] {nX, nY});
                }
            }
        }

        bw.flush();
        bw.close();
    }
}