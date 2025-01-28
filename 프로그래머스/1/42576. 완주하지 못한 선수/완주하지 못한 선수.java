import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String result ="";
        
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        for(String name : participant){
            map.put(name, map.getOrDefault(name, 0)+1);
        }
        for(String name : completion){
            map.put(name, map.get(name)-1);
        }
        
        for(String n : map.keySet()){
            if(map.get(n) != 0){
                result = n;
                break;
            }
        }
        
        return result;
    }
}