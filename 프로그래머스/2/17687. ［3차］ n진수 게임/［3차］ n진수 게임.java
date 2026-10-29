import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        int cnt = 0; // 숫자 차례대로 올리기
        int index = 0;
        while(answer.length() < t){
            String num = Integer.toString(cnt, n); // n진수로 나누어 만들어진 수
            for(char c : num.toCharArray()){
                index++; // index번째일 때 몇 번째 사람일까? cnt % m
                if(index % m == p % m){
                    answer.append(c);
                }
                if(answer.length() == t)
                    break;
            }
            cnt++;
        }
        //System.out.println(answer);
        
        return answer.toString().toUpperCase();
    }
}
/*
- Integer.toString(i, n)은 i를 n진수로 바꾸는 메서드
- 바꾼 다음, charArray로 만들어 하나씩 Stringbuilder에 순번에 맞추어 저장
*/
