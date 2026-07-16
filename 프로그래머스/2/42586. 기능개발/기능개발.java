import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> al = new ArrayList<>();
        
        Stack<Integer> st = new Stack<>();
        int n = 100;
        for(int i=0;i<progresses.length;i++){
            int lp = (100 - progresses[i]); // 남은 퍼센티지
            int completedNum = lp / speeds[i]; 
            if(lp % speeds[i] != 0){
                completedNum += 1;
            } // 남은 일 수 구하기
            
            if(st.empty() || i == 0){
                st.push(completedNum);
                n = completedNum;
                continue;
            }
            
            if(n >= completedNum) // 현재 작업이 앞 작업보다 같거나 빠를 경우, stack에 저장
                st.push(completedNum);
            else { // 현재 작업이 앞 작업보다 느리면, 지금까지 있던 내용 저장
                al.add(st.size());
                st.clear();
                st.push(completedNum);
                n = completedNum;
            }
        }
        al.add(st.size());
        
        int[] answer = new int[al.size()];
        for(int i=0;i<al.size();i++){
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}