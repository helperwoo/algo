import java.util.*;

class Solution {
    public int[] mX = {0, 1, 0, -1};
    public int[] mY = {1, 0, -1, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        
        for (int[] rect : rectangle) {
            int startX = rect[0] * 2;
            int endX = rect[2] * 2;
            int startY = rect[1] * 2;
            int endY = rect[3] * 2;
            
            for (int i=startX; i<endX+1; i++) {
                for (int j=startY; j<endY+1; j++) {
                    if (i==startX || i==endX || j==startY || j==endY) {
                        if (map[i][j] == 0) {
                            map[i][j] = 1;    
                        }
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }
        
        Queue<int[]> q = new LinkedList();
        q.offer(new int[] {characterX * 2, characterY * 2, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if (cur[0] == itemX * 2 && cur[1] == itemY * 2) {
                return (cur[2]+1) / 2;
            }
            
            for (int i=0; i<4; i++) {
                int nX = cur[0]+this.mX[i];
                int nY = cur[1]+this.mY[i];
                
                if (nX < 0 || nX > 100 || nY < 0 || nY > 100) {
                    continue;
                }
                
                if (map[nX][nY] == 1) {
                    q.offer(new int[] {nX, nY, cur[2]+1});
                    map[cur[0]][cur[1]] = 3;
                }
            }
        }
        
        return 0;
    }
}