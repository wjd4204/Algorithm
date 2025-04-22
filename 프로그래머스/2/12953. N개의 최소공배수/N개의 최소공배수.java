import java.util.*;

class Solution {
    
    // 최대공약수 구하기
    public int getGCM(int a, int b){
        if(a % b == 0){
            return b;
        }
        
        return getGCM(b, a % b);
    }
    
    // 최소공배수 구하기
    public int getLCM(int[] arr){
        if(arr.length == 1)
            return arr[0];
        
        int gcm = getGCM(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcm;
        
        for(int i=2;i<arr.length;i++){
            lcm = (lcm * arr[i]) / getGCM(lcm, arr[i]);
        }
        
        return lcm;
    }
    
    public int solution(int[] arr) {
        int answer = arr[0];
        
        Arrays.sort(arr);
        answer = getLCM(arr);
        
        
        return answer;
    }
}