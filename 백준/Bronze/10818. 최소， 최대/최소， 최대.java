import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<count; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(list.stream().min(Comparator.naturalOrder()).get() + " " + list.stream().max(Comparator.naturalOrder()).get());
        bw.flush();
        bw.close();
    }
}