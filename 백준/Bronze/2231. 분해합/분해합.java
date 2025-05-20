import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int number = Integer.parseInt(str);

        int result = 0;
        for (int i = 1; i <= number; i++) {
            int cur = i;
            int sum = 0;

            while (cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }

            if (sum + i == number) {
                result = i;
                break;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}