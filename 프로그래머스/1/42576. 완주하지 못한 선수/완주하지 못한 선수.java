import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String result = "";
        
        HashMap<String, Integer> m = new HashMap<>();
        for(String s : participant){
            m.put(s, m.getOrDefault(s, 0)+1);
        }
        for(String s : completion){
            m.put(s, m.get(s)-1);
        }
        
        for(String s : m.keySet()){
            if(m.get(s) != 0){
                result = s;
                break;
            }
        }
        
        return result;
    }
}
// participant, completion 배열