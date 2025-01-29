import java.util.*;

class Solution {
    
    static int answer = 0;
    static boolean[] visited;
    
    public int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        
        DFS(0, numbers, 0, target);
        
        return answer;
    }
    
    public void DFS(int index, int[] numbers, int sum, int target){
        if(index == numbers.length){
            if(sum == target)
                answer+=1;
            return;
        }
        
        int next = index+1;
        
        DFS(next, numbers, sum+numbers[index], target);
        DFS(next, numbers, sum-numbers[index], target);
        
    }
}