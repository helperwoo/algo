import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Character> list = new LinkedList<>();
        for (char ch : br.readLine().toCharArray()) {
            list.add(ch);
        }
        int cnt = Integer.parseInt(br.readLine());

        ListIterator<Character> iter = list.listIterator(list.size());
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);

            switch (cmd) {
                case 'L':
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case 'D':
                    if (iter.hasNext()) iter.next();
                    break;
                case 'B':
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    };
                    break;
                case 'P':
                    char ch = st.nextToken().charAt(0);
                    iter.add(ch);
                    break;
            }
        }
        for (Character ch : list) {
            bw.write(ch);
        }

        bw.flush();
        bw.close();
    }
}