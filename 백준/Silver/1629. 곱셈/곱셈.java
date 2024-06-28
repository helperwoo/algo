import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long res = recur(a, b, c);
        bw.write(Long.toString(res));
        bw.flush();
        bw.close();
    }

    public static long recur(long a, long b, long c) {
        if (b == 1) return (a % c);
        long value = recur(a, (b / 2), c);
        value = (int) (value * value % c);
        if (b%2 == 0) return value;
        else return (value * a % c);
    }
}