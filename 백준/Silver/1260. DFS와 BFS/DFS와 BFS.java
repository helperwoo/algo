import java.util.*;

public class Main {
    static int n;
    static int m;
    static int v;
    static int[][] lines;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        lines = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            lines[a][b] = lines[b][a] = 1;
        }

        dfs();
        System.out.println();
        Arrays.fill(visited, false);
        bfs();
    }

    static void dfs() {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (!visited[cur]) {
                visited[cur] = true;
                System.out.print(cur + " ");

                for (int i = n; i > 0; i--) {
                    if (!visited[i] && lines[cur][i] == 1) {
                        stack.push(i);
                    }
                }
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (!visited[cur]) {
                visited[cur] = true;
                System.out.print(cur + " ");

                for (int i = 1; i < n + 1; i++) {
                    if (!visited[i] && lines[cur][i] == 1) {
                        queue.offer(i);
                    }
                }
            }
        }
    }
}