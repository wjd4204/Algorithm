class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        var n1 = n
        
        while(n1 > 0){
            var num: Int = n1 % 10;
            answer += num;
            
            n1 /= 10;
        }

        return answer
    }
}