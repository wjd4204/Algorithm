import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        
        dfs(0, 0, numbers,target);
        
        return answer;
    }
    
    public void dfs(int i, int sum, int[] numbers, int target){
        if(sum == target && i == numbers.length){
            answer+=1;
            return;
        }
        
        if(i == numbers.length)
            return;
        
        int num = numbers[i];
        //System.out.println(i + " " + sum);
        dfs(i+1, sum + num, numbers, target);
        dfs(i+1, sum - num, numbers, target);
        
    }
    
}