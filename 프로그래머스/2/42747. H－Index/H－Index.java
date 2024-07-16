import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);

        /* 1. 오름차순한 배열에서 특정 인덱스보다 위에 있는 책 개수와 아래에 있는 책 개수 찾기
           2. (인용이 더 높은 책 개수)>=(현 인덱스보다 낮은 수) && (인용이 더 낮은 책 개수)<=(현 인덱스)
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