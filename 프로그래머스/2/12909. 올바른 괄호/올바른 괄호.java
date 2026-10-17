import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<Character> deque = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                deque.addFirst(ch);
            } else {
                if(deque.isEmpty())
                    return false;
                
                if(deque.getFirst() == '('){
                    deque.pollFirst();
                } else deque.addFirst(ch);
            }
        }
        
        if(!deque.isEmpty())
            return false;

        return answer;
    }
}