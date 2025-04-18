import java.util.*;

// 1. 0을 다 제거
// 2. 1만 있는 문자열의 길이를 2진 변환
class Solution {

    public String convertToBinary(int num){
        String answer = "";
        int rest = 0;
        while(num>=1){
            rest = num % 2;
            answer = String.valueOf(rest) + answer;
            num/=2;
        }
        
        return answer;
    }
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        String num = "";
        while(!s.equals("1")){
            num = "";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1')
                    num+="1";
                else {
                    answer[1] += 1;
                }
            }
            s = convertToBinary(num.length());
            answer[0] += 1;
        }
        
        
        return answer;
    }
}