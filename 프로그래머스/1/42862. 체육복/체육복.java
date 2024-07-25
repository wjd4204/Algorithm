import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        /*
        2가지 경우를 생각
        1. 여유분이 있지만 도난당한 이들
        2. 그냥 도난당한 이들
         */

        //1. 여유분이 있지만 도난당한 이들
        for(int i=0;i< lost.length;i++){
            for(int j=0;j< reserve.length;j++){
                if(lost[i] == reserve[j]){
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer += 1;
                    break;
                }
            }
        }

        //2. 그냥 도난당한 애들
        for(int i=0;i< lost.length;i++){
            for(int j=0;j< reserve.length;j++){
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]){
                    reserve[j] = -1;
                    answer += 1;
                    break;
                }
            }
        }
        
        return answer;
    }    

}