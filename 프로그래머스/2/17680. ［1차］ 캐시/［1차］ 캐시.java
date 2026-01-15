import java.util.*;

class Solution {
    
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Deque<String> q = new LinkedList<>();
        for(int i=0;i<cities.length;i++){ // LRU는 Deque 이용하여 구현
            if(cacheSize == 0){
                answer = cities.length * 5;
                break;
            }
            String city = cities[i].toLowerCase();
            if(!q.contains(city)){
                if(q.size() < cacheSize){
                    q.add(city);
                    answer += 5;
                } else{
                    q.poll();
                    q.add(city);
                    answer += 5;
                } 
            } else{
                q.remove(city);
                q.add(city);
                answer += 1;
            }
            //System.out.println(q + " " + answer);
        }
        
        return answer;
    }
}
