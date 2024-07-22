import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) arr1[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr1);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) arr2[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            int start = 0, end = N-1, res = 0;

            while (start <= end) {
                int mid = (start + end)/2;

                if (arr1[mid] < arr2[i]) {
                    start = mid+1;
                } else if (arr1[mid] > arr2[i])  {
                    end = mid-1;
                } else {
                    res = 1;
                    break;
                }
            }

            bw.write(res + "\n");
        }

        bw.flush();
        bw.close();
    }
}
