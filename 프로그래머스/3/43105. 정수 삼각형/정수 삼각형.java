import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        
        int sum = triangle[0][0];
        for(int i=triangle.length-2;i>=0;i--){
            for(int j=0;j<triangle[i].length;j++){
                
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        
        return triangle[0][0];
    }
}
// 높이가 N인층 
// n층일 때, i번째 요소는 아래층 접근 시 i, i+1에만 접근이 가능
/*
     1
    2 3
   4 5 6
  7 8 9 10
11 12 13 14 15
*/