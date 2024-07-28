import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int n;
        int move = name.length() - 1;

        /*  1. 'name'만큼의 길이의 A로 이루어진 문자열 생성
            2. 이동할 최소 횟수 구하기
            3. 알파벳 변환 횟수 구하기
        */
        for(int i = 0;i<name.length();i++){
            n = i + 1;
            while(n < name.length() && name.charAt(n) == 'A')
                n+=1;
            move = Math.min(move, i * 2 + name.length() - n);
            move = Math.min(move, (name.length() - n) * 2 + i);

        }


        // 각 알파벳 횟수 구하기
        for(int i=0;i<name.length();i++){
            int num = name.charAt(i) - 65;
            num = Math.min(num, 26-num);
            answer += num;
        }
        answer += move;
        
        return answer;
    }
}