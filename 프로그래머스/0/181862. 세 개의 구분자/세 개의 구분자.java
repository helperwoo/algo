import java.util.stream.Stream;

class Solution {
    public String[] solution(String myStr) {
        String str = myStr.replaceAll("[abc]", ",");
        String[] arr = Stream.of(str.split(",")).filter(item -> !item.isEmpty()).toArray(String[]::new);
        return arr.length == 0 ? new String[]{"EMPTY"} : arr;
    }
}