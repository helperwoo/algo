class Solution {
    public int solution(int a, int b) {
        int first = Integer.parseInt(String.valueOf(a) + String.valueOf(b));
        int second = Integer.parseInt(String.valueOf(b) + String.valueOf(a));
        return first > second ? first : second;
    }
}