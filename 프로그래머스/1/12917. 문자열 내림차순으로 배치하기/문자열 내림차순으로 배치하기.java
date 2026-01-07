import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        
        String str = new String(charArray);
        String answer = "";
        for(int i=str.length() - 1;i>=0;i--){
            answer += str.charAt(i);
        }
        
        return answer;
    }
}