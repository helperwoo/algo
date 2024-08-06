import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] line;
    static int[] parent;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        line = new ArrayList[N+1];
        parent = new int[N+1];

        for (int i = 1; i <= N; i++) line[i] = new ArrayList<>();
        for (int i=1; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            line[a].add(b);
            line[b].add(a);
        }

        recur(1);

        for (int i=2; i<=N; i++) bw.write(parent[i] + "\n");
        bw.flush();
        bw.close();
    }

    public static void recur(int node) {
        for (int child : line[node]) {
            if (child == parent[node]) continue;

            parent[child] = node;
            recur(child);
        }
    }
}

