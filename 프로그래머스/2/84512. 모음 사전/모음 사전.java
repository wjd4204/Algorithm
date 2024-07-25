class Solution {
    //dfs
    private static final char[] ALPHABETS = {'A', 'E', 'I', 'O', 'U'};
    private static int answer;
    private static String currentWord; 

    public static int solution(String word) {
        currentWord = word;
        answer = 0;

        for (char c : ALPHABETS) {
            if (dfs(String.valueOf(c))) {
                return answer;
            }
        }
        return answer;
    }

    private static boolean dfs(String str) {
        answer++;
        if (str.equals(currentWord)) {
            return true;
        }
        if (str.length() == 5) { 
            return false;
        }

        for (char c : ALPHABETS) { 
            if (dfs(str + c)) { //모음 추가해 dfs 호출
                return true;
            }
        }
        return false;
    } 
}