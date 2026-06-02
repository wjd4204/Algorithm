import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a){
            answer += (n / a * b); // 우선 빈병 저장
            n = (n / a * b) + (n % a); // n은 빈병 회수 후 다시 받는 값으로 저장.
        }
        
        return answer;
    }
}
/*
1. a개를 주면 b를 주는 회사.
n개 나누기 a를 하여 다시 콜라를 얻고 마셔 몫은 n에 저장하고, 나머지는 
*/