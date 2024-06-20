import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> list = new ArrayList<>();

        String input = br.readLine();
        while (input != null) {
            list.add(Integer.parseInt(input));
            input = br.readLine();
        }

        int max = list.stream().max(Comparator.naturalOrder()).get();
        bw.write(max + "\n" + (list.indexOf(max)+1));
        bw.flush();
        bw.close();
    }
}