import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[26];

        String str = br.readLine().toUpperCase();
        for (char ch : str.toCharArray()) {
            arr[ch-65]++;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        List<Integer> list = Arrays.stream(arr).boxed().filter(item -> item == max).collect(Collectors.toList());

        if (list.size() > 1) {
            bw.write("?");
        } else {
            int idx = Arrays.stream(arr).boxed().collect(Collectors.toList()).indexOf(max);
            bw.write(String.valueOf((char) (idx + 65)));
        }
        bw.flush();
        bw.close();
    }
}
