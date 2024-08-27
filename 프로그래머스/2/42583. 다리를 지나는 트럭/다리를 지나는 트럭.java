import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> list = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i : truck_weights)
            list.offer(i);
        for(int i=0;i<bridge_length;i++){
            bridge.offer(0);
        }

//        System.out.println(list);
//        System.out.println(bridge);

        // 다리에 있는 트럭 무게를 매 반복마다 확인
        int sum = 0;
        int answer = 0;
        while(result.size() != truck_weights.length){
            if(bridge.peek() != 0){
                sum-=bridge.peek();
                result.add(bridge.poll());
            }
            else bridge.poll();

            if(list.isEmpty())
                bridge.offer(0);
            else if(sum + list.peek() <= weight){
                sum+=list.peek();
                bridge.offer(list.poll());
            }
            else{
                bridge.offer(0);
            }
            answer+=1;
            //System.out.println(result);
        }
        
        return answer;
    }
}
