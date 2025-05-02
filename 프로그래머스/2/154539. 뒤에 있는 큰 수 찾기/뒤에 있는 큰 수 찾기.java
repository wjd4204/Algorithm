import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = numbers.length - 1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(numbers[i]);
                answer[i] = -1;
                continue;
            }
            int flag = 0;
            while(!stack.isEmpty()){
                int num = stack.peek();
                if(num > numbers[i]){
                    stack.push(numbers[i]);
                    flag = 1;
                    answer[i] = num;
                    break;
                }
                stack.pop();
            }
            if(flag == 0){
                stack.push(numbers[i]);
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}
