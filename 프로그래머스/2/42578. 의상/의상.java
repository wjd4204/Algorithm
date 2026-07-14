import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0)+1);
        }
        
        System.out.println(hm);
        for(String s : hm.keySet()){
            answer *= (hm.get(s) + 1);
        }
        // if(hm.size() >= 2)
        //     answer += clothes.length;
        
        
        return answer - 1;
    }
}