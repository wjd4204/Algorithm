import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {
        int result = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0;i< scoville.length;i++){
            q.offer(scoville[i]);
        }
        //System.out.println(q);

        int first = q.peek();
        if(first >= k)
            return 0;
        while(!q.isEmpty()){
            int size = q.size(); // -1을 위한 사이즈 얻기
            
            int n1 = q.poll();
            if(n1 >= k){
                break;
            }
            int n2 = q.poll();
            int level = n1 + n2 * 2;

            if(size == 2 && level < k){
                result = -1;
                break;
            }
            
            q.offer(level);
            result += 1;
        }
        
        return result;
    }
}