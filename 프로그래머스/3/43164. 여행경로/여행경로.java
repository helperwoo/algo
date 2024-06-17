import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        boolean[] used = new boolean[tickets.length];
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            } else {
                return a[0].compareTo(b[0]);
            }
        });
        
        Stack<String> stack = new Stack();
        ArrayList<String> result = new ArrayList();
        stack.push("ICN");
        
        while (!stack.isEmpty()) {
            String cur = stack.peek();
            boolean hasNext = false;
            
            for (int i=0; i<tickets.length; i++) {
                if (!used[i] && cur.equals(tickets[i][0])) {
                    used[i] = true;
                    stack.push(tickets[i][1]);
                    hasNext = true;
                    break;
                }
            }
            
            if (!hasNext) {
                result.add(stack.pop());
            }
        }
        
        Collections.reverse(result);
        return result.toArray(new String[0]);
    }
}