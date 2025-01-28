import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int result = 0;
        HashMap<Integer, Integer> type = new HashMap<Integer, Integer>();
        
        for(int i : nums){
            type.put(i, type.getOrDefault(i, 0)+1);
        }
        
        if(type.size() <= nums.length/2){
            result = type.size();
        }
        else{
            result = nums.length/2;
        }
        
        return result;
    }
}