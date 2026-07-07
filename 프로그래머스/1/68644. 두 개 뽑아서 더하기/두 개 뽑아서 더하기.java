import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set<Integer> hs = new HashSet<>();
        
        for(int i=0;i<numbers.length - 1;i++){
            for(int j=i+1;j<numbers.length;j++){
                hs.add(numbers[i] + numbers[j]);
            }
        }
        
        List<Integer> list = new ArrayList<>(hs);
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
//중복을 허용해서는 안됨
// HashSet이용