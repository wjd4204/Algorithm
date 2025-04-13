import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty()){
                char in = stack.peek();
                if(ch == in){
                    stack.pop();
                } else{
                    stack.push(ch);
                }
            } else stack.push(ch);
            //System.out.println(stack);
        }
        
        if(stack.isEmpty())
            answer = 1;

        return answer;
    }
}