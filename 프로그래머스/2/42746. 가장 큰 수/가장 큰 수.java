import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        String answer = "";

        for(int i=0;i< nums.length;i++){
            nums[i] = String.valueOf(numbers[i]);
        }

//        for(int i=0;i< nums.length;i++){
//            for(int j=i;j<nums.length;j++){
//                if(Integer.parseInt(nums[i]+nums[j]) < Integer.parseInt(nums[j]+nums[i])) {
//                    String tmp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = tmp;
//                }
//            }
//        }

        Arrays.sort(nums, (s1, s2) -> (s2+s1).compareTo(s1+s2));

        if(nums[0].equals("0"))
            answer = "0";
        else {
            for (int i = 0; i < nums.length; i++) {
                answer += nums[i];
            }
        }
        
        return answer;
    }
}