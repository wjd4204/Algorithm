import java.util.*;

class Solution {
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int currentServer = 0; // 현재 서버 수
        HashMap<Integer, Integer> endTime = new HashMap<>();
        
        for(int i=0;i<players.length;i++){
            if(endTime.containsKey(i)){
                currentServer -= endTime.get(i);
                endTime.remove(i);
            }
            
            // players[i]가 0이 아닐 때 인원을 확인하고 서버 증설 여부를 확인
            if(players[i] != 0){
                int requiredServer = players[i] / m; // 필요한 최소 서버 수
                if(currentServer < requiredServer){
                    endTime.put(Integer.valueOf(i+k), Integer.valueOf(requiredServer - currentServer));
                    answer += (requiredServer - currentServer);
                    currentServer += (requiredServer - currentServer);
                }
            }
            
            System.out.println(answer);
        }
        
        return answer;
    }
}