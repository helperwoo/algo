import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];

        for (int i=0; i<N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope);

        int max = rope[0] * N;
        for (int i=0; i<N; i++) {
            max = Math.max(max, rope[i] * (N - i));
        }

        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
    }
}
