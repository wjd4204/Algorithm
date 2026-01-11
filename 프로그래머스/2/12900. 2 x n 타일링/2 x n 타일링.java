class Solution {
    
    int answer = 0;
    
    public int solution(int n) {
        
        int prev1 = 1;
        int prev2 = 1;
        for(int i=2;i<=n;i++){
            answer = (prev1 + prev2) % 1000000007;
            prev1 = prev2;
            prev2 = answer;
        }
        
        return answer;
    }
}