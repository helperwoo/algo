import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine().replaceAll("[a-zA-Z.\\s]*", "");
        Stack<Character> stack = new Stack<>();
        while (input != null) {
            for (char ch : input.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.add(ch);
                } else {
                    char top = stack.peek();
                    if ((top == '(' && ch == ')') || (top == '[' && ch == ']')) {
                        stack.pop();
                    } else {
                        stack.add(ch);
                    }
                }
            }

            if (stack.isEmpty()) {
                bw.write("yes");
            } else {
                bw.write("no");
            }

            stack.clear();

            input = br.readLine();
            if (input.equals(".")) break;
            input = input != null ? input.replaceAll("[a-zA-Z.\\s]*", "") : null;
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}