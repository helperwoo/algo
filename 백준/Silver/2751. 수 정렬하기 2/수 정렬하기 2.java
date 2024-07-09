import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length];
        for (int i=0; i<length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] result = merge(arr);

        for (int num : result) {
            bw.write(Integer.toString(num));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static int[] merge(int[] arr) {
        int[] result = new int[arr.length];
        int[] first = Arrays.copyOfRange(arr, 0, arr.length/2);
        int[] second = Arrays.copyOfRange(arr, arr.length/2, arr.length);
        Arrays.sort(second);
        int a = 0, b = 0;

        if (first.length >= 2) {
            first = merge(first);
            second = merge(second);
        }

        for (int i=0; i<arr.length; i++) {
            if (a == first.length) {
                result[i] = second[b++];
            } else if (b == second.length) {
                result[i] = first[a++];
            } else if (first[a] > second[b]) {
                result[i] = second[b++];
            } else if (first[a] < second[b]) {
                result[i] = first[a++];
            }
        }

        return result;
    }
}
