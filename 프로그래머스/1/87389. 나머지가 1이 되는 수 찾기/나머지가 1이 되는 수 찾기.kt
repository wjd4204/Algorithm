class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var num: Int = n - 1
        
        for(i in 2..num){
            if(num % i == 0){
                answer = i
                break;
            }
        }
        
        return answer
    }
}