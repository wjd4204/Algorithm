import java.util.*;

// 시작 11:33
class Solution {
    
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights); // 정렬
        Map<Double, Integer> map = new HashMap<>();
        
        for(int w : weights) {
            double w1 = w * 1.0;
            double w2 = (w * 2.0) / 3.0;
            double w3 = (w * 2.0) / 4.0;
            double w4 = (w * 3.0) / 4.0;
            
            if(map.containsKey(w1)){
                answer += map.get(w1);
            }
            if(map.containsKey(w2)){
                answer += map.get(w2);
            }
            if(map.containsKey(w3)){
                answer += map.get(w3);
            }
            if(map.containsKey(w4)){
                answer += map.get(w4);
            }
            
            map.put(w * 1.0, map.getOrDefault(w*1.0, 0) + 1);
        }
        
        
        return answer;
    }
}
// 비율별 숫자를 생성하여 비교하는 코드