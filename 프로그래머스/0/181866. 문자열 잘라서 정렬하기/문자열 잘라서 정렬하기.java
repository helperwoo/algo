import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public String[] solution(String myString) {
        String[] arr = myString.split("x");
        ArrayList<String> list = new ArrayList();
        
        for(String str : arr) {
            if(!str.isEmpty()) {
                list.add(str);                
            }
        }
        
        String[] result = new String[list.size()];
        list.toArray(result);
        Arrays.sort(result);
        return result;
    }
}