import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().replace("()", ".");
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        for (char ch : input.toCharArray()) {
            if (ch == '.') {
                sum += stack.size();
            } else if (ch == '(') {
                stack.push(ch);
                sum++;
            } else {
                stack.pop();
            }
        }
        bw.write(Integer.toString(sum));
        bw.flush();
        bw.close();
    }
}