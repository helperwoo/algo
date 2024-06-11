import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] priorities, int location) {
        List<int[]> list = IntStream.range(0, priorities.length).mapToObj(i -> new int[] {priorities[i], i}).collect(Collectors.toList());
        Queue<int[]> q = new LinkedList(list);
        List<int[]> result = new ArrayList();
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            boolean isPriority = true;
            for (int[] process : q) {
                if (process[0] > current[0]) {
                    isPriority = false;
                    break;
                }
            }

            if (isPriority) {
                result.add(current);
            } else {
                q.offer(current);
            }
        }
        
        for (int i=0; i<result.size(); i++) {
            if (result.get(i)[1] == location) {
                return i+1;
            }
        }
        
        return -1;
    }
}