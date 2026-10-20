import java.util.*;
// 10:46
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0;i<commands.length;i++){
            int end = commands[i][1];
            int start = commands[i][0];
            int[] arr = new int[end-start+1];
            
            for(int j=start-1;j<end;j++){
                arr[j-(start-1)] = array[j];
            }
            
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        }
        
        return answer;
    }
}

// 10:52