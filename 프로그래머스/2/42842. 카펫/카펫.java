import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        for(int i=3;i<=sum/2;i++){
            if(sum % i != 0)
                continue;
            int garo = sum / i;
            int sero = i;
            if((garo-2) * (sero-2) ==yellow){
                answer[0] = garo;
                answer[1] = sero;
                break;
            }
        }
        
        return answer;
    }
}