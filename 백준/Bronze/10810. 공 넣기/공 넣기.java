import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] basket = new int[n];

        String input = br.readLine();
        while (input != null) {
            st = new StringTokenizer(input);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int i=start-1; i < end; i++) {
                basket[i] = ball;
            }

            input = br.readLine();
        }
        br.close();

        String result = Arrays.stream(basket).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        bw.write(result);
        bw.flush();
        bw.close();
    }
}