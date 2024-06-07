class Solution {
    public int solution(int a, int b, int c) {
        if ((a == b && a != c)|| (a == c && b != c) || (b == c && a != c)) {
            return (a+b+c) * (int)((Math.pow(a,2)+Math.pow(b,2)+Math.pow(c,2)));
        } else if (a == b && b == c) {
            return (a+b+c) * (int)((Math.pow(a,2)+Math.pow(b,2)+Math.pow(c,2))) * (int)((Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)));
        } else {
            return a+b+c;
        }
    }
}