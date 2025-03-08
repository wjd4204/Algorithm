import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String num = Integer.toBinaryString(n);
        int ncnt = 0;
        for(int i=0;i<num.length();i++){
            if(num.charAt(i) == '1')
                ncnt+=1;
        }
        
        while(true){
            n+=1;
            num = Integer.toBinaryString(n);
            int cnt = 0;
            for(int i=0;i<num.length();i++){
                if(num.charAt(i) == '1')
                    cnt+=1;
            }
            if(ncnt == cnt){
                answer = Integer.parseInt(num, 2);
                break;
            }
            cnt=0;
        }
        
        return answer;
    }
}