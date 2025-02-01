import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int num = 10;
        Queue<Integer> q = new LinkedList<>();
        for(int i : arr){
            if(num != i){
                q.add(i);
                num = i;
            }
        }

        int[] answer = new int[q.size()];
        int size = q.size();
        
        for(int i=0;i<size;i++){
            answer[i] = q.poll();
        }

        
        
        return answer;
    }
}