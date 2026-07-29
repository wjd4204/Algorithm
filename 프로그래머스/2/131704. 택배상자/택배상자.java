import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> s = new Stack();
        int cnt = 0; // order index
        int num = 1; // 컨테이너에서 나오는 순서
        
        while(true){
            if(order.length < num)
                break;
            
            if(num == order[cnt]){ // 같으면 담기, 인덱스 증가
                answer+=1;
                cnt++;
            } else {
                s.push(num);
            }
            
            while(!s.isEmpty()){ // 같지 않으면 stack 검사
                //System.out.println(s.peek() + " " + order[cnt]);
                if(s.peek() != order[cnt])
                    break;
                else if(s.peek() == order[cnt]) {
                    s.pop();
                    cnt++;
                    answer+=1;
                }
            }
            
            
            
            //System.out.println(s);
            num++;
        }
        
        return answer;
    }
}
/*
일반 컨베이어 - 큐
보조 컨베이어 - 스택

1. 해당 상자가 아니라면 스택에 보관
2. 해당 번째의 상자를 싣기(보조에 있다면 보조에서 빼내기)
종료 조건은??
*/