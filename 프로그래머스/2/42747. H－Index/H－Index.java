import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);

        /* 1. 배열을 오름차순
           2. i번째 인용값보다 적은 값들중 해당 인용값보다 인용률이 높은 논문 수와 같은 값 찾아 비교하여 저장하기.
           2. answer에 저장된 값보다 더 높은 값을 가지고 있으면 answer값을 변경.
         */
        int ind = 0;
        for(int i=0;i< citations.length;i++){
            int n = citations[i];
            int maxCount = 0;
            for(int j=n;j>=0;j--){
                if(j == citations.length-i){
                    if(maxCount < j)
                        maxCount = j;
                }
            }

            if(answer < maxCount)
                answer = maxCount;
        }
        
        return answer;
    }
}
