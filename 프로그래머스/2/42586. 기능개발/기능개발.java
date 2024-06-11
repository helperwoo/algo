import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> pQ = new LinkedList();
        IntStream.of(progresses).forEach(pQ::add);
        Queue<Integer> sQ = new LinkedList();
        IntStream.of(speeds).forEach(sQ::add);
            
        List<Integer> result = new ArrayList<Integer>();
        
        int workDay = 1;
        while (!pQ.isEmpty()) {
            Integer prog = pQ.peek() + sQ.peek() * workDay;
            
            if (prog >= 100) {
                Integer cnt = 1;
                pQ.remove();
                sQ.remove();
                
                while(!pQ.isEmpty() && (pQ.peek() + sQ.peek() * workDay) >= 100) {
                    cnt++;
                    pQ.remove();
                    sQ.remove();  
                };
                
                result.add(cnt);
            }
            
            workDay++;
        };
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}