import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        long[] arr = new long[length];

        for (int i=0; i<length; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        int count = 0;
        int maxCount = 0;
        long result = 0;

        for (int i=0; i<length; i++) {
            if (i != 0 && arr[i] != arr[i-1]) {
                count = 0;
            }

            count++;

            if (count > maxCount) {
                maxCount = count;
                result = arr[i];
            }
        }

        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
    }
}
