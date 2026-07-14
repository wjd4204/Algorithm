import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int result = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }
        
        result = hs.size();
        if(nums.length / 2 < result)
            result = nums.length / 2;
        
        return result;
    }
}
// 빠른 탐색 요구
// 가장 많은 종류의 값을 반환