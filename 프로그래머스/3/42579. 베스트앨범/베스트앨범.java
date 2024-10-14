import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> g = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();

        for(int i=0;i<genres.length;i++){
            g.put(genres[i], g.getOrDefault(genres[i], 0) + plays[i]); // 장르별 총 횟수
            count.put(genres[i], count.getOrDefault(genres[i], 0) + 1); // 장르별 갯수
        }

        List<String> keySet = new ArrayList<>(g.keySet());
        keySet.sort((o1, o2) -> g.get(o2).compareTo(g.get(o1)));

        List<Integer> result = new ArrayList<>();

        for(String key : keySet){
            int cnt = count.get(key);
            System.out.println(cnt);
            if(cnt > 2)
                cnt = 2;
            int max = 0;
            int max2 = 0;
            int maxInd = Integer.MAX_VALUE;
            int max2Ind = Integer.MAX_VALUE;
            for(int i=0;i<genres.length;i++){
                if(genres[i].equals(key)){
                    if(max==0) {
                        max = plays[i];
                        maxInd = i;
                    }
                    else{
                        if(max<plays[i]){
                            max2 = max;
                            max2Ind = maxInd;
                            max = plays[i];
                            maxInd = i;
                        }
                        else{
                            if(max2 < plays[i]){
                                max2 = plays[i];
                                max2Ind = i;
                            }
                        }
                    }
                }
            }
            System.out.println("maxInd : " + maxInd + " maxInd2 : " + max2Ind);
            if(cnt == 1)
                result.add(maxInd);
            else if(cnt == 2) {
                result.add(maxInd);
                result.add(max2Ind);
            }
        }

        int[] answer = new int[result.size()];
        for(int i=0;i< answer.length;i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}