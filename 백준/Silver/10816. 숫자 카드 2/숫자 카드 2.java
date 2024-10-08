import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr1);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int s = 0;
            int e = N;
            int m;

            while (s < e) {
                m = (s+e)/2;
                if (arr2[i] <= arr1[m]) {
                    e = m;
                } else {
                    s = m+1;
                }
            }
            int start = s;

            s = 0;
            e = N;
            while (s < e) {
                m = (s+e)/2;
                if (arr2[i] < arr1[m]) {
                    e = m;
                } else {
                    s = m + 1;
                }
            }
            int end = s;

            bw.write(end - start + " ");
        }

        bw.flush();
        bw.close();
    }
}

