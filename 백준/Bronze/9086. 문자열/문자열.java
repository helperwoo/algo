import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();

        String input = br.readLine();
        while (input != null) {
            bw.write(String.valueOf(input.charAt(0)) + String.valueOf(input.charAt(input.length()-1)) + "\n");
            input = br.readLine();
        }
        br.close();

        bw.flush();
        bw.close();
    }
}