import java.util.*;

class Solution {
    
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        if(x==y)
            return 0;
        
        int[] visited = new int[y+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        
        while(!q.isEmpty()){
            int num = q.poll();
            
            int n1 = num + n;
            int n2 = num * 2;
            int n3 = num * 3;
            
            if(n1 <= y && visited[n1] == 0){
                visited[n1] = visited[num] + 1;
                if(n1 == y){
                    break;
                }
                q.offer(n1);
            }
            if(n2 <= y && visited[n2] == 0){
                visited[n2] = visited[num] + 1;
                if(n2 == y){
                    break;
                }
                q.offer(n2);
            }
            if(n3 <= y && visited[n3] == 0){
                visited[n3] = visited[num] + 1;
                if(n3 == y){
                    break;
                }
                q.offer(n3);
            }
        }
        
        if(visited[y] == 0)
            visited[y] = -1;
        
        return visited[y];
    }
}
/*
- bfs 사용
1. 3개를 탐색
2. visited 배열을 통해 이미 방문했다면 큐에 삽입 x
15, 20, 30, 
*/