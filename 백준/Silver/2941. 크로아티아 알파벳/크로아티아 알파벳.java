import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.replaceAll("(c=)|(c-)|(dz=)|(d-)|(lj)|(nj)|(s=)|(z=)", " ");

        bw.write(Integer.toString(str.length()));
        bw.flush();
        bw.close();
    }
}
