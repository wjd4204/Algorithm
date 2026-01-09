class Solution {
    
    long answer = 0;
    
    public long solution(int n) {
        
        long prev1 = 1;
        long prev2 = 1;
        
        for(int i=2;i<=n;i++){
            long sum = (prev1 + prev2) % 1234567;
            prev1 = prev2;
            prev2 = sum;
        }
        
        return prev2;
    }
}
/*
멀리뛰기 문제는 경우의 수로 풀어야 함
1. 재귀 메서드 사용
2. DP
3. 백트래킹
4. 피보나치
*/