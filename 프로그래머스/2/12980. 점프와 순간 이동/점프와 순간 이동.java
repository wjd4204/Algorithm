import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1; // 최소 건전지 사용량
        
        while(n != 1){
            if(n % 2 == 0){
                n = n / 2;
            } else {
                ans += 1;
                n = (n-1) / 2;
            }
        }
        

        return ans;
    }
}