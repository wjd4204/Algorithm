import java.util.*;

// 17:31

class Solution {
    
    public int solution(int[] citations) {
        int answer = 0;
        
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for(int i=0;i<n;i++){
            int h = n - i; // i번째의 인용 수보다 같거나 많은 논문 개수
            if(citations[i] >= h) // 현재 i번째의 인용 수가 논문보다 크거나 같은가?
                return h;
        }
        
        return answer;
    }
}
/*
10, 10, 10
10회 이상 인용된 논문이 3개
h는 3
10은 citations[i] */