import java.util.*;

class Solution {
    public int count = 0;
    public int solution(int[] numbers, int target) {
        dfs(0,numbers,target,0);
        return this.count;
    }
             
    public void dfs(int depth, int[] numbers, int target, int sum) {
        if(depth == numbers.length) {
            if (sum == target) this.count++;
        } else {
           dfs(depth+1,numbers,target,sum+numbers[depth]);
           dfs(depth+1,numbers,target,sum-numbers[depth]);
        }
    }
}