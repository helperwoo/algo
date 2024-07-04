import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int seq = Integer.parseInt(br.readLine());
        int std = 1;
        int interval = 0;

        while (true) {
            if (std <= seq && seq < (std+interval+1)) {
                break;
            }
            std += (++interval);
        }

        if (interval%2 == 0) {
            bw.write((interval+1-(seq-std))+"/"+(seq-std+1));
        } else {
            bw.write((seq-std+1)+"/"+(interval+1-(seq-std)));
        }
        bw.flush();
        bw.close();
    }
}
