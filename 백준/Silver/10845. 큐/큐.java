import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();
        int cmdCnt = Integer.parseInt(br.readLine());
        int last = 0;

        StringTokenizer st;
        for (int i=0; i<cmdCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    queue.offer(num);
                    last = num;
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        bw.write(Integer.toString(-1));
                    } else {
                        bw.write(Integer.toString(queue.poll()));
                    }
                    bw.newLine();
                    break;
                case "size":
                    bw.write(Integer.toString(queue.size()));
                    bw.newLine();
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        bw.write(Integer.toString(1));
                    } else {
                        bw.write(Integer.toString(0));
                    }
                    bw.newLine();
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        bw.write(Integer.toString(-1));
                    } else {
                        bw.write(Integer.toString(queue.peek()));
                    }
                    bw.newLine();
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        bw.write(Integer.toString(-1));
                    } else {
                        bw.write(Integer.toString(last));
                    }
                    bw.newLine();
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}