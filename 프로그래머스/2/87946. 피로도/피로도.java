import java.util.*;

// 20:45
class Solution {
    
    int max = Integer.MIN_VALUE;
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        permutation(dungeons, 0, new boolean[dungeons.length], k);
        
        return max;
    }
    
    public void permutation(int[][] dungeons, int sum, boolean[] visited,
                            int k){
        
        if(sum >= max)
            max = sum;
        
        
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                permutation(dungeons, sum+1, visited, k-dungeons[i][1]);
                visited[i] = false;
            }
        }
    }
}