import java.util.*;
import java.io.*;

// 인덱스가 0 or 공백 다음이면 알파벳 안에 있을 경우, 대문자로 변경
// 아니면 다 소문자로 출력
class Solution {
    public String solution(String s) {
        String answer = "";
        int blank = 1;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ' '){
                answer += ch;
                blank = 1;
            }
            else if(i == 0 || blank == 1){
                if(ch >= 'a' && ch <= 'z')
                    answer = answer + String.valueOf(ch).toUpperCase();
                else
                    answer += ch;
                blank = 0;
            }
            else{
                if(ch >= 'A' && ch <= 'Z')
                    answer = answer + String.valueOf(ch).toLowerCase();
                else
                    answer += ch;
            }
        }
        
        return answer;
    }
}