import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[100001];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {n, 0});
        visit[n] = true;

        int[] move = new int[] {1, -1, 2};
        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == k) {
                queue.clear();
                count = cur[1];
                break;
            }

            for (int i=0; i<move.length; i++) {
                int next = move[i] != 2 ? cur[0] + move[i] : cur[0] * move[i];

                if (next < 0 || next > 100000 || visit[next]) {
                    continue;
                }

                queue.offer(new int[] {next, cur[1]+1});
                visit[next] = true;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}