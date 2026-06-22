import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left;i<=right;i++){
            int cnt = 2;
            if(i == 1){
                answer -= 1;
                continue;
            }
            for(int j=i-1;j>=2;j--){
                if(i % j == 0)
                    cnt+=1;
            }
            //System.out.println(i + " " + cnt);
            if(cnt % 2 == 0)
                answer += i;
            else answer -= i;
        }
        
        return answer;
    }
}

// 약수란?
// n이 주어졌을 때, 0으로 나누어 떨어지는 수