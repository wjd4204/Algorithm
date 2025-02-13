import java.util.*;

class Solution {
    public String solution(String s) {
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        String answer = "";
        
        String[] st = s.split(" ");
        for(int i=0;i<st.length;i++){
            Integer num = Integer.valueOf(st[i]);
            if(max < num)
                max = num;
            if(min > num)
                min = num;
            
            System.out.println(num);
        }
        
        answer = min + " " + max;
        
        return answer;
    }
}