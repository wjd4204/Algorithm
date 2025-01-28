import java.util.HashMap;


class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        HashMap<String, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rankMap.put(players[i], i);
        }

        // 호출된 선수의 순위를 교환
        for (String name : callings) {
            int currentRank = rankMap.get(name);

            // 순위 변경
            if (currentRank > 0) {
                String tmp = players[currentRank];
                players[currentRank] = players[currentRank - 1];
                players[currentRank - 1] = tmp;

                // HashMap의 순위도 업데이트
                rankMap.put(players[currentRank], currentRank);
                rankMap.put(players[currentRank - 1], currentRank - 1);
            }
        }
        
        
        return players;
    }
}