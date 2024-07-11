import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        int start = 0;
        int end = 0;
        int result = Integer.MAX_VALUE;

        while (end < N && start <= end) {
            int diff = list.get(end) - list.get(start);

            if (M <= diff) {
                result = Math.min(result, diff);
                start++;
            } else {
                end++;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
