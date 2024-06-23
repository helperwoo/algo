import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        List<Integer> list = IntStream.rangeClosed(97, 122).boxed().collect(Collectors.toList());

        for (int num : list) {
            int count = 0;
            for (char ch : input.toCharArray()) {
                if ((int) ch == num) count++;
            }
            bw.write(count + " ");
        }

        bw.flush();
        bw.close();
    }
}