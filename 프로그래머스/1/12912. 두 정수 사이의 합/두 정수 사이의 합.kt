class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        var tmp: Int = 0
        
        var min: Int = a
        var max: Int = b
        
        if(a > b){
            tmp = min;
            min = max;
            max = tmp;
        }
        
        for(i in min..max){
            answer += i.toLong()
        }
        
        return answer
    }
}