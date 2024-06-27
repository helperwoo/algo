import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visit = new int[100001];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {n, 0});
        visit[n] = 0;

        int[] move = new int[] {1, -1, 2};
        int time = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (count == 0) time = cur[1];

            if (cur[1] > time) {
                queue.clear();
                break;
            }

            if (cur[0] == k) count++;
            if (count > 0) continue;

            for (int i=0; i<move.length; i++) {
                int next = move[i] != 2 ? cur[0] + move[i] : cur[0] * move[i];

                if (next < 0 || next > 100000 || (visit[next] != 0 && visit[next] <= time)) {
                    continue;
                }

                queue.offer(new int[] {next, cur[1]+1});
                visit[next] = cur[1]+1;
            }
        }

        bw.write(time + "\n" + count);
        bw.flush();
        bw.close();
    }
}