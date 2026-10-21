import java.util.*;

class Solution {
    
    static HashSet<Integer> scoreSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        char[] chs = numbers.toCharArray();
        Arrays.sort(chs);
        boolean[] visited = new boolean[chs.length];
        
        for(int r = 1;r<=chs.length;r++){
            permutation(chs, new char[r], visited, 0, r);
        }
        
        System.out.println(scoreSet);
        for(int num : scoreSet){
            if(isPrime(num))
                answer+=1;
        }
        
        
        return answer;
    }
    
    public static boolean isPrime(int num){
        if(num <= 1) return false;
        
        for(int i = 2;i*i <= num ;i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
    
    public static void permutation(char[] chs, char[] output, boolean[] visited, int depth, int r){
        
        if(depth == r){
            String s = new String(output);
            
            int num = Integer.parseInt(s);
            scoreSet.add(num);
            
            return;
        }
        
        for(int i=0;i<chs.length;i++){
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = chs[i];
                permutation(chs, output, visited, depth+1, r);
                visited[i] = false;
            }
        }
    }
}