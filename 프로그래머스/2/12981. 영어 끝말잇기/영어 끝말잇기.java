import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // 1. hashmap에 이전에 저장된 낱말여부 확인
        // 2. 제일 마지막에 사용한 단어의 끝 알파벳과 이번 단어의 알파벳이 일치하는지 확인
        int cnt = 1;
        char lastAlphabet = words[0].charAt(words[0].length() - 1);
        
        HashMap<String, Integer> relay = new HashMap<>();
        relay.put(words[0], 1);
        for(int i=1;i<words.length;i++){
            relay.put(words[i], relay.getOrDefault(words[i], 0) + 1);
            
            if((i+1) % n == 1){
                cnt += 1;
            }
            if(relay.get(words[i]) >= 2 || lastAlphabet != words[i].charAt(0)){
                System.out.println(i + " " + lastAlphabet + " " + words[i].charAt(0));
                int num = (i+1) % n;
                if(num == 0)
                    num = n;
                answer[0] = num;
                break;
            }
            lastAlphabet = words[i].charAt(words[i].length() - 1);
        }
        
        if(answer[0] == 0)
            answer[1] = 0;
        else answer[1] = cnt;

        return answer;
    }
}