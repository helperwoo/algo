import java.io.*;

public class Main {
    public static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        recur(0,0, n, false);

        StringBuilder sb = new StringBuilder();
        for (char[] arr : map) {
            for (char ch : arr) {
                sb.append(ch);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void recur(int x, int y, int n, boolean blank) {
        if (blank) {
            for (int i = x; i < x+n; i++) {
                for (int j = y; j < y+n; j++) {
                    map[i][j] = ' ';
                }
            }
            return;
        }

        if (n == 1) {
            map[x][y] = '*';
            return;
        }

        int count = 0;
        for (int i = x; i < x+n; i+=(n/3)) {
            for (int j = y; j < y+n; j+=(n/3)) {
                count++;
                if (count == 5) {
                    recur(i, j, n/3, true);
                } else {
                    recur(i, j, n/3, false);
                }
            }
        }
    }
}