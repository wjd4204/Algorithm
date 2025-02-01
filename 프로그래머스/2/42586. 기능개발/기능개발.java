import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> days = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        int first = 0;
        
        for(int i=0;i<progresses.length;i++){
            int day = (100 - progresses[i]); // 남은 일 수 구하기
            if(day % speeds[i] != 0){
                day = day / speeds[i] + 1;
            }
            else {
                day = day/ speeds[i];
            }
            
            if(stack.isEmpty()){ // 비어있으면 첫번째 업무 push
                stack.push(day);
                first = stack.peek();
            }
            else{
                //System.out.println(first + " " + day);
                if(first >= day){ // 안에 들어있는 값이 현재 값보다 클 때, push하기
                    stack.push(day);
                }
                else{ // 안에 들어있는 값이 현재 값보다 작을 때, 그동안의 업무들을 days에 업데이트하기
                    days.add(stack.size());
                    stack.clear();
                    stack.push(day);
                    first = day;
                }
            }
        }
        
        if(stack.size() != 0)
            days.add(stack.size());
        System.out.println(stack);
        
        int[] answer = days.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}