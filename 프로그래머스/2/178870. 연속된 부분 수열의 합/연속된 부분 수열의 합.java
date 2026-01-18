import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = 0;
        answer[1] = sequence.length - 1;
        
        // 슬라이딩 윈도우로 푸는 문제
        int l = 0; int r = 0;
        int sum = 0;
        while(true){
            if(sum >= k){
                if(sum == k){ // 같으면 비교
                    if(r-1-l < answer[1] - answer[0]){
                        answer[1] = r-1;
                        answer[0] = l;
                    } else if((r-1-l == answer[1] - answer[0]) && l < answer[0]){
                        answer[1] = l;
                        answer[0] = r-1;
                    }
                }
                sum -= sequence[l++];
            } else {
                if(r == sequence.length)
                    break;
                sum += sequence[r++];
            }
        }
        
        return answer;
    }
}