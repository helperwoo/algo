import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new LinkedList<>();
        int cmdCnt = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=0; i<cmdCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "push_front":
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        bw.write(Integer.toString(-1));
                    } else {
                        bw.write(Integer.toString(deque.pollFirst()));
                    }
                    bw.newLine();
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        bw.write(Integer.toString(-1));
                    } else {
                        bw.write(Integer.toString(deque.pollLast()));
                    }
                    bw.newLine();
                    break;
                case "size":
                    bw.write(Integer.toString(deque.size()));
                    bw.newLine();
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        bw.write(Integer.toString(1));
                    } else {
                        bw.write(Integer.toString(0));
                    }
                    bw.newLine();
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        bw.write(Integer.toString(-1));
                    } else {
                        bw.write(Integer.toString(deque.peekFirst()));
                    }
                    bw.newLine();
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        bw.write(Integer.toString(-1));
                    } else {
                        bw.write(Integer.toString(deque.peekLast()));
                    }
                    bw.newLine();
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}