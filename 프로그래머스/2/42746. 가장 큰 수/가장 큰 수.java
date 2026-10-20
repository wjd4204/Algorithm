import java.util.*;

// 16:46
class Solution {
    
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] nums = new String[numbers.length];
        
        for(int i=0;i<nums.length;i++){
            nums[i] = numbers[i] + "";
        }
        
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2){
                return (o2 + o1).compareTo(o1+o2);
            }
        });
        
        for(String i : nums){
            answer += i;
        }
        
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
// 맨 앞자리만 정렬