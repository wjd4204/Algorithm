class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer: Int = 0
        
        for(i in 0..signs.size-1){
            answer += when (signs[i]) {
                true -> {
                    absolutes[i]
                }
                else -> {
                    -absolutes[i]
                }
            }
            println(answer)
        }
        
        
        return answer
    }
}