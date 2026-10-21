import java.util.*;

// 16:18
class Solution {
    
    public static HashSet<Integer> hs = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        char[] ch = numbers.toCharArray();
        
        for(int i=1;i<=ch.length;i++){
            permutation(ch, new char[i], new boolean[ch.length], 0, i);
        }
        
        
        for(int num : hs){
            if(isPrime(num))
                answer+=1;
        }
        
        return answer;
    }
    
    public static boolean isPrime(int num){
        if(num <= 1) return false;
        
        for(int i=2;i * i <= num;i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
    
    public static void permutation(char[] ch, char[] output, boolean[] visited, int depth, int r){
        
        if(depth == r){
            String st = new String(output);
            int num = Integer.parseInt(st);
            
            hs.add(num);
            
            return;
        }
        
        for(int i=0;i<ch.length;i++){
            if(!visited[i]){
                output[depth] = ch[i];
                visited[i] = true;
                permutation(ch, output, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }
}