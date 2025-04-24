import java.util.*;

class Point{
    int x;
    int y;
    public Point(int y, int x){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    int[] xPosition = {-1, 0, 1, 0};
    int[] yPosition = {0, 1, 0, -1};
    int[][] visited;
    
    public void bfs(int[][] maps){
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0));
        visited[0][0] = 1;
        
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int i=0;i<4;i++){
                int newX = p.x + xPosition[i];
                int newY = p.y + yPosition[i];
                if(newX >= 0 && newX < visited[0].length && newY >= 0 && newY < visited.length){
                    if(maps[newY][newX] == 1){
                        maps[newY][newX] = 0;
                        q.offer(new Point(newY, newX));
                        visited[newY][newX] = visited[p.y][p.x] + 1;
                    }
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        visited = new int[maps.length][maps[0].length];
        
        bfs(maps);
        if(visited[maps.length-1][maps[0].length - 1] == 0)
            answer = -1;
        else answer = visited[maps.length-1][maps[0].length - 1];
        
        return answer;
    }
}