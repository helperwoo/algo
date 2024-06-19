import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> dice = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        dice.add(Integer.parseInt(st.nextToken()));
        dice.add(Integer.parseInt(st.nextToken()));
        dice.add(Integer.parseInt(st.nextToken()));

        if (Collections.max(dice).equals(Collections.min(dice))) {
            bw.write(String.valueOf(10000 + dice.get(0) * 1000));
        } else if (dice.get(0).equals(dice.get(1)) ||  dice.get(0).equals(dice.get(2))) {
            bw.write(String.valueOf(1000 + dice.get(0) * 100));
        } else if (dice.get(1).equals(dice.get(2))) {
            bw.write(String.valueOf(1000 + dice.get(1) * 100));
        } else {
            bw.write(String.valueOf(Collections.max(dice) * 100));
        }

        bw.flush();
        bw.close();
    }
}