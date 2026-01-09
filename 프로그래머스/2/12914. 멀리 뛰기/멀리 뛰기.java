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
피보나치 수열인 것을 파악하고 구현하였습니다.
1. 재귀함수의 경우 함수가 계속 분기하기 때문에 시간복잡도가 O(N^2) - 시간 초과
2. for-loop를 통해 시간복잡도 단축 O(N)
ㄹ
*/