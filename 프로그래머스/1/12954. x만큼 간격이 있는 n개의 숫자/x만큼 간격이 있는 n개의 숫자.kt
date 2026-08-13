class Solution {
    fun solution(x: Int, n: Int): LongArray {
        val list = mutableListOf<Long>()
        
        var num: Long = 0
        for(i in 0..n-1){
            num += x.toLong()
            list.add(num)
        }
        
        var answer = list.toLongArray()
        
        return answer
    }
}