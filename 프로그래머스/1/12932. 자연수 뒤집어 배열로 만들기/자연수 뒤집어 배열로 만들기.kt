class Solution {
    fun solution(n: Long): IntArray {
        var input: String = n.toString()
        var n1: Long = n
        val answer = mutableListOf<Int>()
        
        for(i in 0..input.length-1){
            var num: Int = (n1%10).toInt()
            answer.add(num)
            
            n1 /= 10
        }
        
        val arr = answer.toIntArray()
        
        return arr
    }
}