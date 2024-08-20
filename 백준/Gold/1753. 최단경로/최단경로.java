import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[] d = new int[V+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[K] = 0;

        ArrayList<int[]>[] adj = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[u].add(new int[] {v, w});
        }

        Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        q.offer(new int[] {K, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int dist = cur[1];

            for (int i = 0; i < adj[node].size(); i++) {
                int[] next = adj[node].get(i);

                if (dist + next[1] < d[next[0]]) {
                    d[next[0]] = dist + next[1];
                    q.offer(new int[] {next[0], d[next[0]]});
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (d[i] == Integer.MAX_VALUE) bw.write("INF\n");
            else bw.write(d[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}