import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String elem = br.readLine();
            map1.put(i, elem);
            map2.put(elem, i);
        }

        for (int i = 0; i < M; i++) {
            String item = br.readLine();
            if (item.chars().allMatch(Character::isDigit)) {
                bw.write(map1.get(Integer.parseInt(item)) + "\n");
            } else {
                bw.write(map2.get(item) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}

