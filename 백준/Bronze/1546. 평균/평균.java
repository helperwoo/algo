import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        ArrayList<Double> scores = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            double score = Double.parseDouble(st.nextToken());
            scores.add(score);
        }

        double max = Collections.max(scores);
        OptionalDouble avg = scores.stream().mapToDouble((score) -> {
            return score / max * 100;
        }).average();

        if (avg.isPresent()) {
            System.out.print(avg.getAsDouble());
        }
    }
}