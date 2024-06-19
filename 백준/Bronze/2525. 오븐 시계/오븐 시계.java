import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        hour = hour + (minute + time) / 60;
        hour = hour >= 24 ? hour - 24 : hour;
        minute = (minute + time) % 60;

        bw.write(hour + " " + minute);

        bw.flush();
        bw.close();
    }
}