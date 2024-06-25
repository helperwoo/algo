import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int cmdCnt = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=0; i<cmdCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.add(num);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        bw.write(Integer.toString(-1));
                    } else {
                        bw.write(Integer.toString(stack.pop()));
                    }
                    bw.newLine();
                    break;
                case "size":
                    bw.write(Integer.toString(stack.size()));
                    bw.newLine();
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        bw.write(Integer.toString(1));
                    } else {
                        bw.write(Integer.toString(0));
                    }
                    bw.newLine();
                    break;
                case "top":
                    if (stack.isEmpty()) {
                        bw.write(Integer.toString(-1));
                    } else {
                        bw.write(Integer.toString(stack.peek()));
                    }
                    bw.newLine();
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}