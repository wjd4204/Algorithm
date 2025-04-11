import java.util.*;

class Solution {
    
    public int solution(int[] diffs, int[] times, long limit) {
        long sum;
        int flag = 0;
        
        int l = 1;
        int r = Integer.MIN_VALUE;
        for(int i=0;i<diffs.length;i++){
            if(r < diffs[i])
                r = diffs[i];
        }
        int answer = r;
        
        while(l < r) {
            int level = (l+r)/2; // 숙련도
            sum = times[0];
            for(int j=1;j<diffs.length;j++){
                int prevTime = times[j-1];
                int diff = diffs[j] - level;
                if(diff <= 0)
                    diff = 0;
                sum += diff * (times[j] + prevTime) + times[j];
                if(sum > limit)
                    continue;
            }
            
            if(sum <= limit){ // 합이 limit보다 같거나 작지만 최소를 구하고 싶어.
                r = level;
                answer = level;
            }
            else l = level+1;
            
        }
        
        return answer;
    }
}