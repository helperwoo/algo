import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        br.readLine();
        List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(br.readLine());
        int count = 0;

        for (int num : list) {
            if (num == target) count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}