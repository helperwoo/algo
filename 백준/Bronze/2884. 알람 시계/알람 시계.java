import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        if (minute >= 45) {
            minute = minute - 45;
        } else {
            hour = hour > 0 ? hour - 1 : 23;
            minute = minute + (60 - 45);
        }

        bw.write(hour + " " + minute);

        bw.flush();
        bw.close();
    }
}