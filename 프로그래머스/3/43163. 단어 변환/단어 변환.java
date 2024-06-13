import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int step = 0;
        
        if (!Arrays.asList(words).contains(target)) {
            return step;
        }

        Queue<String> q = new LinkedList();
        q.offer(begin);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                String current = q.poll();
                
                if (current.equals(target)) {
                    return step;
                }
                
                for (int j=0; j<words.length; j++) {
                    if (this.compare(current, words[j])) {
                        q.offer(words[j]);
                    }
                }
            }
            
            step++;
        }
        
        return 0;
    }
    
    private boolean compare(String a, String b) {
        int count = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        
        return count == 1;
    }
}