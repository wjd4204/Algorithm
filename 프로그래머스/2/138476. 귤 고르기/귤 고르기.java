import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Arrays.sort(tangerine);
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int cnt = 0;
        int num = tangerine[0];
        int max = 1;
        for(int i=0;i<tangerine.length;i++){
            if(num == tangerine[i]){
                cnt += 1;
                continue;
            }
            
            // 종류가 다르면 지난 값들을 담기
            if(max < cnt)
                max = cnt;
            hashmap.put(cnt, hashmap.getOrDefault(cnt, 0)+1);
            cnt = 1;
            num = tangerine[i];
        }
        if(max < cnt)
                max = cnt;
        hashmap.put(cnt, hashmap.getOrDefault(cnt, 0)+1);
        
        System.out.println(k + " " + hashmap);
        int sum = 0;
        for(int i = max;i>=1;i--){
            if(sum >= k)
                break;
            if(!hashmap.containsKey(i))
                continue;
            int value = hashmap.get(i);
            // 여기서 이미 조건이 충족되면 끝 아니면 for문 계속 실행.
            for(int j=1;j<=value;j++){
                answer++;
                sum += i;
                if(sum >= k)
                    break;
            }
        }
        
        return answer;
    }
}