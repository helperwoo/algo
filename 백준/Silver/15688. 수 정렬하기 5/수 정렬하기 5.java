import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[length];

        for (int i=0; i<length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
        Collections.sort(list);

        for (Integer num : list) {
            bw.write(Integer.toString(num));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
