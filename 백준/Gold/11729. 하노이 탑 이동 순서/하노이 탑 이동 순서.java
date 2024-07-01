import java.io.*;
import java.util.*;

public class Main {
    private static int count = 0;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        recur(size, 1, 2, 3);
        bw.write(Integer.toString(count));
        bw.newLine();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void recur(int size, int a, int b, int c) {
        count++;

        if (size == 1) {
            sb.append(a + " " + c + "\n");
            return;
        }

        recur(size-1, a, c, b);

        sb.append(a + " " + c + "\n");

        recur(size-1, b, a, c);
    }
}