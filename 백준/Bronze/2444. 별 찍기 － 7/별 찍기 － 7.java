import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           
        int num = Integer.parseInt(br.readLine()) - 1;
        for (int i=0; i<num; i++) {
            bw.write(" ".repeat(num-i) + "*".repeat(i));
            bw.write("*");
            bw.write("*".repeat(i) + "\n");
        }
        for (int i=0; i<num; i++) {
            bw.write(" ".repeat(i) + "*".repeat(num-i));
            bw.write("*");
            bw.write("*".repeat(num-i) + "\n");
        }
        bw.write(" ".repeat(num) + "*" + " ".repeat(num));

        bw.flush();
        bw.close();
    }
}