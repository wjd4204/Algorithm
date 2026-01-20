class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int num = storey % 10;
            //System.out.println(num + " " + answer);
            storey /= 10;
            if(num <= 4){
                answer += num;
            } else if(num == 5) {
                if(storey % 10 >= 5){
                    answer += (10-num);
                    storey += 1;
                } else {
                    answer += num;
                }
            }
            else {
                answer += (10-num);
                storey += 1;
            }
        }
        
        return answer;
    }
}