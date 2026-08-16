class Solution {
    fun solution(arr: IntArray): IntArray {
        var answer = intArrayOf()
        
        if(arr.size == 1){
            return intArrayOf(-1)
        }
        
        answer = arr.filter { it != arr.minOrNull() }.toIntArray()
        
        return answer
    }
}