import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return IntStream.rangeClosed(0,n).map(idx -> {
            if (n%2==0) {
                return idx%2==0?(int)Math.pow(idx,2):0;
            } else {
                return idx%2!=0?idx:0;
            }
        }).sum();
    }
}