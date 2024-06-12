import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[computers.length];
        
        for (int i = 0; i < computers.length; i++) {
            visited[i] = false;
        }
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                count++;
                dfs(i, computers, visited);
            }
        }
        
        return count;
    }
    
    public void dfs(int node, int[][] computers, boolean[] visited) {
        Stack<Integer> st = new Stack();
        st.push(node);
        
        while (!st.isEmpty()) {
            node = st.pop();
            for (int i=0; i<computers.length; i++) {
                if (!visited[i] && computers[node][i] == 1) {
                    visited[i] = true;
                    st.push(i);
                }
            }
        }       
    }
}