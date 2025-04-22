import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // for문을 hashmap만큼의 크기만큼 반복
        // 그 안에서 매번 끝까지 가는 형태로 곱해서 더함.
        HashMap<String, Integer> cloth = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            cloth.put(clothes[i][1], cloth.getOrDefault(clothes[i][1], 1) + 1);
        }
        
        for(String key : cloth.keySet()){
            answer *= cloth.get(key);
        }
        answer -= 1;
        
        return answer;
    }
}