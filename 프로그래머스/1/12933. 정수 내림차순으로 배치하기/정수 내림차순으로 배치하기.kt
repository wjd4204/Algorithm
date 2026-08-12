class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        var num: Long = n
        
        val array = Array(10, {0})
        
        while(num > 0){
            var position: Int = (num % 10).toInt()
            array.set(position, array.get(position)+1)
            
            num /= 10
        }
        
        for(i in 9 downTo 0){
            for(j in 0..array.get(i)-1){
                answer = answer * 10 + i
            }
        }
        
        
        return answer
    }
}
