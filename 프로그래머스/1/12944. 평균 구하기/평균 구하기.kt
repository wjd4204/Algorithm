class Solution {
    fun solution(arr: IntArray): Double {
        var answer: Double = 0.0
        
        for(i in 0..arr.size - 1){
            answer += arr[i];
        }
        
        answer = answer / arr.size
        
        return answer
    }
}