import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i<count; i++) {
            String str = br.readLine();

            Stack<Character> stack = new Stack<>();
            boolean isGrp = true;

            for (char ch : str.toCharArray()) {
                if (stack.contains(ch)) {
                    if (stack.peek() != ch) {
                        isGrp = false;
                    }
                } else {
                    stack.push(ch);
                }
            }

            if (isGrp) result++;
        }

        System.out.print(result);
    }
}