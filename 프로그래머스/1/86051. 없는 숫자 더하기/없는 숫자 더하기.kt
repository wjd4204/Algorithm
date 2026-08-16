class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 45
        
        for(i in numbers.indices){
            answer -= numbers[i]
        }
        
        return answer
    }
}