import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] price = new int[N];

        for (int i=0; i<N; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i=N-1; i>=0; i--) {
            count += K / price[i];
            K %= price[i];
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
