import java.util.*;

class Solution {
    
    int answer = 0;
    
    public void combination(int[] list, int start, int depth, 
                            int n, int r, int sum){
        if(depth == r){
            if(sum == 0){
                answer++;
                return;
            }
        }
        
        for(int i=start;i<n;i++){
            combination(list, i+1, depth+1, n, r, sum+list[i]);
        }
    }
    
    public int solution(int[] number) {
        
        combination(number, 0, 0, number.length, 3, 0);
        
        return answer;
    }
}
/*
순서를 고려하지 않은 조합 문제
*/