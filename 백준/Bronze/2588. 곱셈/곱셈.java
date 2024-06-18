import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = b;

        while (c != 0) {
            bw.write(a * (c%10) + "\n");
            c /= 10;
        }

        bw.write(String.valueOf(a*b));
        bw.flush();
        bw.close();
    }
}