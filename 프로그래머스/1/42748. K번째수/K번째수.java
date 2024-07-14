import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0;i< commands.length;i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int ind = commands[i][2];

            List<Integer> list = new ArrayList<>();
            for(int j=start-1;j <= end-1 ;j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(ind-1);
        }
        
        return answer;
    }
}