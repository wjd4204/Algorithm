import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1);
        int[] answer = new int[size];
        
        
        for(int i=0;i<size;i++){
            long idx = left + i;

            long row = idx / n;
            long col = idx % n;

            answer[i] = (int)(Math.max(row, col) + 1);
        }
        
        
        return answer;
    }
}
// 6 / 4 = 1. 2
// 10 / 4 = 2. 2
// 나머지가 있으면 거기 숫자는 (몫) + 1
// 없으면 n
/*
1 2 3 4
2 2 3 4
3 3 3 4
4 4 4 4
*/