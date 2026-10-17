import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 순서 정하기
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        ArrayDeque<Integer> array = new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++){
            q.add(priorities[i]);
            array.addFirst(priorities[i]);
        }
//        System.out.println(q);
        
        // 큐 실행하기(우선순위 보면서 정하기)
        
        while(!array.isEmpty()){
            //System.out.println(array + " " + location);
            int num = array.pollLast();
            
            if(num < q.peek()){
                array.addFirst(num);
            } else {
                q.poll();
                answer+=1;
                if(location == 0)
                    break;
            }
            
            location -= 1;
            if(location < 0){
                location += array.size();
            }
        }
        
        
        return answer;
    }
}