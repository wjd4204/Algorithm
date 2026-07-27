import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        
        int num = 0;
        if(n == 1)
            return "1";
        else if(n == 2)
            return "2";
        else if(n == 3)
            return "4";
        
        while(n >= 1){
            num = n % 3;
            n = n / 3;
            if(num == 1){
                answer = "1" + answer;
            }
            else if(num == 2){
                answer = "2" + answer;
            }
            else if(num == 0){
                answer = "4" + answer;
                n -= 1;
            }
        }
        
        return answer;
    }
}
/*
11은 42이다.
왜? 3으로 나누면 목은 3 나머지가 2. 그러므로 2를 추가

*/