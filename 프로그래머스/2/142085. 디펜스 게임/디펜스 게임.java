import java.util.*;


// 우선순위 큐를 사용하는 문제
/*
1. for-loop로 순회하엿을 때 현재 병사로 현재 라운드의 적을 막을 수 있으면 차감, 
그리고 우선순위 큐에 저장
2. 막지 못했을 때 무적권을 사용하고 우선순위 큐의 적의 수만큼 현재 병사를 플러스
*/
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<enemy.length;i++){
            int ce = enemy[i];
            if(n >= ce){ // 막을 수 있으면 무적권 사용 x
                pq.offer(ce);
                n -= ce;
                answer += 1;
            } else { // 못 막으면 무적권 개수 보고 사용여부 결정
                if(k > 0){
                    if(!pq.isEmpty()){
                        if(pq.peek() > ce){
                            n += pq.poll();
                            n -= ce;
                            pq.offer(ce);
                        }
                    }
                    answer+=1;
                    k-=1;
                } else break;
            }
        }
        
        return answer;
    }
}