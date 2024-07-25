import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int r = a % b;
        int gcd = b;
        while (r != 0) {
            int tmp = gcd;
            gcd = r;
            r = tmp % r;
        }

        bw.write(gcd + "\n" + (a * b) / gcd);
        bw.flush();
        bw.close();
    }
}
