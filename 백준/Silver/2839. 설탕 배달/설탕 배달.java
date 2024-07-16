import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int lg = N/5;
        int result = -1;

        for (int i=lg; i>=0; i--) {
            int tmp = N - i*5;

            if (tmp % 3 == 0) {
                result = i + tmp/3;
                break;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
