class Solution {
    public String solution(String code) {
        char[] codes = code.toCharArray();
        int mode = 0;
        StringBuilder sb = new StringBuilder();
        
        for (int idx=0; idx<codes.length; idx++) {
            if (codes[idx] != '1') {
                if ((mode == 0 && idx%2 == 0) || (mode == 1 && idx%2 != 0)) {
                    sb.append(codes[idx]);
                }
            } else {
                mode = mode == 0 ? 1 : 0;
            }
        }
        
        return sb.length() > 0 ? sb.toString() : "EMPTY";
    }
}