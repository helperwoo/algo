import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];
        answer = answer == 0 ? -1 : answer;
        
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[] {0, 0});
        visited[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.remove();
            int cX = cur[0];
            int cY = cur[1];
            
            for(int i : new int[] {-2,-1,1,2}) {
                int nX = i%2 == 0 ? cX + i/2 : cX;
                int nY = i%2 != 0 ? cY + i : cY;
                
                if (nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1) {
                    continue;
                }
                
                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[cX][cY] + 1;
                    q.add(new int[] {nX, nY});
                }
            }
        }
    }
}