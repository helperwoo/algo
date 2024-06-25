import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int value = 1;
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '(') {
                value *= 2;
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == '[') {
                value *= 3;
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (input.charAt(i-1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
            } else if (input.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (input.charAt(i-1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }
        if (!stack.isEmpty()) bw.write(String.valueOf(0));
        else bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}