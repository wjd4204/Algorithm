import java.util.*;

class Solution {
    
    int answer = 0;
    int[] visited;
    
    void dfs(int num, int[][] computers){
        
        for(int i=0;i<computers.length;i++){
            if(i == num)
                continue;
            if(computers[num][i] == 1 && visited[i] == 0){
                visited[i] = 1;
                dfs(i, computers);
            }
        }

    }
    
    public int solution(int n, int[][] computers) {
        visited = new int[computers.length];
        
        for(int i=0;i<computers.length;i++){
            if(visited[i] == 1)
                continue;
            answer+=1;
            dfs(i, computers);
        }
        
        return answer;
    }
}