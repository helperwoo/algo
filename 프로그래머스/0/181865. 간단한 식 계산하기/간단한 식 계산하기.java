import java.util.stream.Stream;

class Solution {
    public int solution(String binomial) {
        String str = binomial.replaceAll("\\s+", "");
        char op = '+';
        for (char ch : str.toCharArray()) {   
            if (!Character.isDigit(ch)) op = ch;
        }
        String[] nums = str.split("\\" + op);
        
        if (op == '+') return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
        else if (op == '-') return Integer.parseInt(nums[0]) - Integer.parseInt(nums[1]);
        else return Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
    }
}