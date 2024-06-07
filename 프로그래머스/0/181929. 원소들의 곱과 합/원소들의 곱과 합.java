import java.util.stream.IntStream;
import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        int mul = 1, sum = 0;
        for (int num : num_list) {
            mul *= num;
            sum += num;
        }
        return mul < (int)Math.pow(sum,2) ? 1 : 0;
    }
}