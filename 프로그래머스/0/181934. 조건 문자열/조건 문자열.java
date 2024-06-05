class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        Boolean bool = false;
        if (ineq.equals("<")) {
            bool = eq.equals("=") ? n <= m : n < m;
        } else {
            bool = eq.equals("=") ? n >= m : n > m;
        }
        return bool ? 1 : 0;
    }
}