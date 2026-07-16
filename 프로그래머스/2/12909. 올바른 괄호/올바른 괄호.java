import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int cnt = 0;
        Stack<String> st = new Stack<>();
        if(s.charAt(0) == ')')
            return false;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                st.push("(");
                cnt += 1;
            } else {
                if(cnt < 0 || st.empty())
                    return false;
                String tmp = st.peek();
                if(tmp.equals("(") && s.charAt(i) == ')'){
                    st.pop();
                }
            }
        }
        if(!st.empty())
            answer = false;

        return answer;
    }
}