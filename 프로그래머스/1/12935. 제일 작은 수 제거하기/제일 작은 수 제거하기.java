import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] cloneArr = arr.clone();
        Arrays.sort(cloneArr);
        int min = cloneArr[0];
        
        for(int i=0;i<arr.length;i++){
            if(arr[i] == min){
                for(int j=i;j<arr.length-1;j++){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
                break;
            }
        }
        
        int[] answer = new int[arr.length - 1 > 0 ? arr.length-1 : 1];
        if(arr.length > 1){
            System.arraycopy(arr, 0, answer, 0, arr.length-1);
        } else
            answer[0] = -1;
        
        return answer;
    }
}