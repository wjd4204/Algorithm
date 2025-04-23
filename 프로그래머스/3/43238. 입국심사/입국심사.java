import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 0;
        long right = times[times.length - 1] * (long) n;
        long mid = 0;
        long sum = 0;
        long answer = right;
        
        while(left <= right){
            sum = 0;
            mid = (left + right) / 2;
            for(int time : times){
                sum += mid / time;
            }
            if(sum >= n){ // sum의 결과가 n보다 많으면 오른쪽으로 범위를 축소
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}