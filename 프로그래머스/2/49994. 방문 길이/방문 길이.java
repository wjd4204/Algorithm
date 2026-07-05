import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        int answer = 0;
        
        int x = 5;
        int y = 5;
        int[][] map = new int[11][11];
        Set<String> list = new HashSet<>();
        
        for(int i=0;i<dirs.length();i++){
            char ch = dirs.charAt(i);
            String start = "cu" + y + x;
            
            if(ch == 'U'){
                y += 1;
            }
            else if(ch == 'D'){
                y -= 1;
            }
            else if(ch == 'L'){
                x -= 1;
            }
            else if(ch == 'R'){
                x += 1;
            }
            
            if(x < 0){
                x = 0;
                continue;
            } else if(x >= 11){
                x = 10;
                continue;
            }
            
            if(y < 0){
                y = 0;
                continue;
            } else if(y >= 11){
                y = 10;
                continue;
            }
            
            String end = "cu" + y + x;
            list.add(start + " " + end);
            list.add(end + " " + start);
        }
        
        answer = list.size() / 2;
        
        
        return answer;
    }
}
