import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] map = new int[x][y];
        boolean[][] visit = new boolean[x][y];
        for (int i=0; i<y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<x; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[] mx = new int[] {1, -1, 0, 0};
        int[] my = new int[] {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int maxSize = 0;

        for (int i=0; i<x; i++) {
            for (int j=0; j<y; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    int size = 0;
                    queue.offer(new int[] {i, j});
                    visit[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int cx = cur[0];
                        int cy = cur[1];
                        size++;

                        for (int z=0; z<mx.length; z++) {
                            int nx = cx + mx[z];
                            int ny = cy + my[z];

                            if (nx < 0 || nx > x-1 || ny < 0 || ny > y-1) {
                                continue;
                            }

                            if (!visit[nx][ny] && map[nx][ny] == 1) {
                                queue.offer(new int[] {nx, ny});
                                visit[nx][ny] = true;
                            }
                        }
                    }

                    maxSize = Math.max(maxSize, size);
                    count++;
                }

                visit[i][j] = true;
            }
        }

        bw.write(count + "\n" + maxSize);
        bw.flush();
        bw.close();
    }
}