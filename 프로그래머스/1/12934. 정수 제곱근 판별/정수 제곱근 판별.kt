class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        var num: Double = n.toDouble()
        
        var sq = Math.sqrt(num)
        answer = when {
            sq % 1.0 == 0.0 -> {
                sq += 1
                sq.toLong() * sq.toLong()
            }
            else -> {
                -1
            }
        }
        
        return answer
    }
}