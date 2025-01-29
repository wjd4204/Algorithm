import java.util.*;

class Point{
    public int x, y;
    Point(int y, int x){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] x = {-1, 0, 1, 0};
    static int[] y = {0, 1, 0, -1};
    static int[][] visited;
        
    public int solution(int[][] maps) {
        int answer = 9999;
        visited = new int[maps.length][maps[0].length];
        
        BFS(0,0, maps);
        if(visited[maps.length-1][maps[0].length-1] == 0)
            return -1;
        else
            return visited[maps.length-1][maps[0].length-1];
    }
    
    public void BFS(int currentX, int currentY, int[][] maps){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(currentX, currentY));
        visited[currentY][currentX] = 1;
        
        while(!q.isEmpty()){
            Point point = q.poll();
            for(int i=0;i<4;i++){
                int newX = point.x + x[i];
                int newY = point.y + y[i];
                if(newX >= 0 && newX < visited[0].length && newY >= 0 && newY < visited.length && maps[newY][newX] == 1){
                    maps[newY][newX] = 0;
                    q.offer(new Point(newY, newX));
                    visited[newY][newX] = visited[point.y][point.x] + 1;
                }
            }
            
        }
    }

}