import java.util.*;

class Solution {
    
    public static boolean isPrime(long n) {
        System.out.println(n);
        if (n <= 1) return false;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public int solution(int n, int k) {
        int answer = 0;
        
        int num = n;
        String jinsu = "";
        while(num > 0){
            jinsu = (num % k) + jinsu;
            num /= k;
        }
        
        String nn = "";
        for(int i = 0;i<jinsu.length();i++){
            if(jinsu.charAt(i) == '0' && !nn.isEmpty()){
                long p = Long.parseLong(nn);
                if(isPrime(p)){
                    answer += 1;
                }
                nn = "";
            }
            nn = nn + jinsu.charAt(i);
        }
        if (!nn.isEmpty() && isPrime(Long.parseLong(nn))) {
            answer += 1;
        }
        
        
        return answer;
    }
}