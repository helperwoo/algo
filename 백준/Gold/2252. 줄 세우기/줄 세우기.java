import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adj = new ArrayList[N+1];
        int[] degree = new int[N+1];

        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            degree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            if (degree[i] == 0) q.offer(i);
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer student = q.poll();
            result.add(student);

            for (int next : adj[student]) {
                degree[next]--;
                if (degree[next] == 0) q.offer(next);
            }
        }

        for (int std : result) {
            bw.write(std + " ");
        }

        bw.flush();
        bw.close();
    }
}