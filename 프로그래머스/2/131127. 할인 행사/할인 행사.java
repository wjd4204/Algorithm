import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i], number[i]);
        }
        
        int start = 0;
        int end = 0;
        Map<String, Integer> list = new HashMap<>();
        for(int i=0;i<discount.length;i++){
            end = i;
            if (map.containsKey(discount[i])) {
                list.put(discount[i], list.getOrDefault(discount[i], 0) + 1);
            }

            // 2) 윈도우가 10을 넘으면 왼쪽 제거
            if (end - start + 1 > 10) {
                String out = discount[start];
                if (map.containsKey(out)) {
                    int v = list.get(out) - 1;
                    if (v == 0) list.remove(out);
                    else list.put(out, v);
                }
                start += 1;
            }

            // 3) 윈도우가 정확히 10이면 조건 검사
            if (end - start + 1 == 10) {
                boolean ok = true;
                for (String key : map.keySet()) {
                    if (list.getOrDefault(key, 0) != map.get(key)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) answer += 1;
            }
        }
        
        return answer;
    }
}