import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] map = new int[9][9];
        int max = 0;
        int[] matrix = new int[]{0, 0};

        for (int i=0; i<9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                if (max == map[i][j]) {
                    matrix = new int[] {i+1, j+1};
                }
            }
        }

        bw.write(Integer.toString(max));
        bw.newLine();
        bw.write(matrix[0]+ " " + matrix[1]);
        bw.flush();
        bw.close();
    }
}
