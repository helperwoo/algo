import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Meet[] meets = new Meet[N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            meets[i] = new Meet(s, e);
        }

        Arrays.sort(meets, new MeetComparator());

        int count = 0;
        int end = 0;
        for (int i=0; i<N; i++) {
            if (end <= meets[i].s) {
                end = meets[i].e;
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}

class Meet {
    public int s;
    public int e;

    public Meet(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

class MeetComparator implements Comparator<Meet> {
    @Override
    public int compare(Meet o1, Meet o2) {
        if (o1.e == o2.e) return o1.s - o2.s;
        return o1.e - o2.e;
    }
}
