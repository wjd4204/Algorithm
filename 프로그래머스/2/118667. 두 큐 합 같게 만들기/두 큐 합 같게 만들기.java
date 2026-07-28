import java.util.*;

class Solution {
    
    long sum1 = 0;
    long sum2 = 0;
    
    private long convertToQueue(int[] list, Queue<Integer> q){
        long sum = 0;
        
        for(int i=0;i<list.length;i++){
            q.add(list[i]);
            sum += list[i];
        }
        
        return sum;
    }
    
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        sum1 = convertToQueue(queue1, q1);
        sum2 = convertToQueue(queue2, q2);
        
        int answer = 0;
        
        if ((sum1+sum2) % 2 != 0) {
            return -1;
        }
        
        int limit = (queue1.length + queue2.length) * 2;
        
        int num = 0;
        while(answer < limit){
            if(sum1 == sum2){
                break;
            }
            
            if(sum1 > sum2){
                if (q1.isEmpty()) {
                    return -1;
                }
                
                num = q1.poll();
                q2.add(num);
                sum1 -= num;
                sum2 += num;
            }
            else if(sum1 < sum2){
                if (q2.isEmpty()) {
                    return -1;
                }
                
                num = q2.poll();
                q1.add(num);
                sum1 += num;
                sum2 -= num;
            }
            
            // System.out.println("q1 "+q1);
            // System.out.println("q2 "+q2);
            
            
            answer+=1;
        }
        
        return sum1 == sum2 ? answer : -1;
    }
}
/*
1. 원소의 합을 알기 위해서는 두 큐의 합을 먼저 구함
2. 
*/