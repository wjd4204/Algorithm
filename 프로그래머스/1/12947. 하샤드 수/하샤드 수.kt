class Solution {
    fun solution(x: Int): Boolean {
        var answer = true
        
        var arr = x.toString().toCharArray()
        var num: Int = 0
        for(i in 0..arr.size - 1){
            num += arr[i].toString().toInt() // char에서 Int로 변환할 때는 String 변환 후 Int 변환
        }
        
        //println("" + x + " " + num)
        answer = when {
            x % num == 0 -> {
                true
            }
            else -> {
                false
            }
        }
        
        return answer
    }
}