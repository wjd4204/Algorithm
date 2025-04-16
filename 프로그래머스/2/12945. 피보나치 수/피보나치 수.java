import java.util.*;

class Solution {
    
    public int solution(int n) {
        int answer = 1;
        int num = 0;
        
        for(int i=1;i<n;i++){
            int num1 = num;
            num = answer;
            answer = (num1 + answer) % 1234567;
        }
        
        return answer;
    }
}