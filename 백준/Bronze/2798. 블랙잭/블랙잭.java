import java.io.*;
import java.util.*;

public class Main {
    private static int result = 0;
    private static int count;
    private static int max;
    private static int[] card;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        count = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        card = new int[count];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<count; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<count; i++) {
            recur(1, i, card[i]);
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }

    public static void recur(int times, int index, int sum) {
        if (times == 3) {
            if (sum <= max) {
                result = Math.max(result, sum);
            }
            return;
        }

        for (int i=index+1; i<count; i++) {
            recur(times+1, i,sum+card[i]);
        }
    }
}
