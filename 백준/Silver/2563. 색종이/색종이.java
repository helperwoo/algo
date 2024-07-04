import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[101][101];
        int size = 0;
        int overlay = 0;

        for (int i=0; i<count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j=x; j<x+10; j++) {
                for (int k=y; k<y+10; k++) {
                    if (map[j][k] == 0) {
                        map[j][k] = 1;
                        size++;
                    } else if (map[j][k] == 1) {
                        map[j][k] = 2;
                        overlay++;
                    }
                }
            }
        }

        bw.write(Integer.toString(size));
        bw.flush();
        bw.close();
    }
}
