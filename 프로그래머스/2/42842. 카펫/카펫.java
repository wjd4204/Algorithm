class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int w = brown+yellow; // 넓이
        
        for(int i=3;i<=w/2;i++){
            if(w % i == 0){
                if((w / i -2) * (i-2) == yellow){
                    answer[0] = w / i;
                    answer[1] = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}
/*
brown과 yellow를 더하기.
더햇다면 해당 넓이의 가로를 순회하며 각 -2를 했을 때의 결과가 yellow와 같다면 승인
*/