import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> st = new Stack<Character>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push('(');
            } else {
                if (st.isEmpty()) return false;
                else st.pop();
            }
        }
        
        return st.isEmpty();
    }
}