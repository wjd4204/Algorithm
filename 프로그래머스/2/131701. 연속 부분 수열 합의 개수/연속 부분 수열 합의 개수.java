import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        int sum;
        for(int i=0;i<elements.length;i++){
            sum = 0;
            for(int j=i;j<i+elements.length;j++){
                sum += elements[j % elements.length];
                set.add(sum);
            }
        }
        //Collections.sort(list);
        //System.out.println(list);
        answer = set.size();
        
        return answer;
    }
}