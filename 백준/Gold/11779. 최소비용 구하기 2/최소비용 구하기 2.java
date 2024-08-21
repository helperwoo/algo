import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            list.add(new int[] {s, e, f});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int[] fee = new int[n+1];
        Arrays.fill(fee, Integer.MAX_VALUE);
        fee[start] = 0;

        q.offer(new int[] {start, fee[start]});

        int[] pre = new int[n+1];

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int city = cur[0];
            int charge = cur[1];

            if (fee[city] < charge) continue;

            for (int i=0; i<list.size(); i++) {
                int[] next = list.get(i);

                if (city == next[0] && charge + next[2] < fee[next[1]]) {
                    pre[next[1]] = next[0];
                    fee[next[1]] = charge + next[2];
                    q.offer(new int[] {next[1], fee[next[1]]});
                }
            }
        }

        Stack<Integer> s = new Stack<>();
        s.push(end);

        while (s.peek() != start) {
            int city = s.peek();
            s.push(pre[city]);
        }

        bw.write(fee[end] + "\n");
        bw.write(s.size() + "\n");
        while (!s.isEmpty()) {
            bw.write(s.pop() + " ");
        }
        bw.flush();
        bw.close();
    }
}