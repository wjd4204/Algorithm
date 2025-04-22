import java.util.*;

class Solution {
    
    public boolean isParen(char a, char b){
        if(a == '(' && b == ')')
            return true;
        else if(a == '[' && b == ']')
            return true;
        else if(a == '{' && b == '}')
            return true;
        
        return false;
    }
    
    public boolean isRight(String str){
        
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            // System.out.println(i + " " + stack);
            if(stack.isEmpty()){
                if(str.charAt(i) == ']' || str.charAt(i) == ')' || str.charAt(i) == '}')
                    return false;
                stack.push(str.charAt(i));
                continue;
            }
            
            if(str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == '{'){
                stack.push(str.charAt(i));
            }
            else {
                char ch = stack.peek();
                if(isParen(ch, str.charAt(i))){
                    stack.pop();
                } 
                else {
                    return false;
                }
            }
            
            
        }
        
        if(stack.isEmpty())
            return true;
        return false;
    }
    public int solution(String s) {
        int answer = 0;
        
        String newS = "";
        for(int i=0;i<s.length()-1;i++){
            //System.out.println(s);
            if(isRight(s))
                answer+=1;
            
            // 왼쪽으로 회전
            char first = s.charAt(0);
            newS = "";
            for(int j=1;j<s.length();j++){
                newS = newS + s.charAt(j);
            }
            newS += first;
            s = newS;
        }
        
        return answer;
    }
}