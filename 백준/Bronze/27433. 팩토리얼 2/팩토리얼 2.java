import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        long result = recur(1, a, 1);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    public static long recur(int now, int target, long res) {
        if (0 == target) return res;
        res *= now;
        if (now == target) return res;
        return recur(now+1, target, res);
    }
}