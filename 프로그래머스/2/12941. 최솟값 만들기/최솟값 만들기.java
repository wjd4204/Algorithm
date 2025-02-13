import java.util.*;

class Solution
{
    public int sum(int []A, int[] B, int answer){
        
        for(int i=0;i<A.length;i++){
            answer += A[i] * B[B.length-1-i];
        }
        
        return answer;
    }
    
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;

        Solution so = new Solution();

        return so.sum(A, B, answer);
    }
}