import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        IntStream.range(0, num_list.length).forEach(idx -> {
            if (num_list[idx]%2 == 0) even.append(num_list[idx]);
            else odd.append(num_list[idx]);
        });
        return Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());
    }
}