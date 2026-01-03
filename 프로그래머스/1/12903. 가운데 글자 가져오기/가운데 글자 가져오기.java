class Solution {
    public String solution(String s) {
        String answer = "";
        
        if(s.length() % 2 != 0){
            int mid = s.length() / 2;
            answer = "" + s.charAt(mid);
        }
        else{
            int mid = s.length() / 2;
            answer = answer + s.charAt(mid-1) + s.charAt(mid);
        }
        return answer;
    }
}