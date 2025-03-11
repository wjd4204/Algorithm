class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n%2==1)
            answer = 1;
        
        for(int i=1;i<n;){
            if(n%i==0)
                answer+=1;
            i+=2;
        }
        
        return answer;
    }
}