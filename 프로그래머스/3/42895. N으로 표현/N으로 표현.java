import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        if(N == number)
            return 1;
        
        List<Set<Integer>> list = new ArrayList<>();
        for(int i=0;i<9;i++){
            list.add(new HashSet<>());
        }
        
        int num = 0;
        for(int i=1;i<=8;i++){
            num = num * 10 + N;
            list.get(i).add(num);
        }
        
        for(int i=1;i<=8;i++){
            for(int j=1;j<i;j++){
                
                for(int n1 : list.get(j)){
                    for(int n2 : list.get(i-j)){
                        list.get(i).add(n1+n2);
                        list.get(i).add(n1-n2);
                        list.get(i).add(n1*n2);
                        
                        if(n2 != 0)
                            list.get(i).add(n1/n2);
                    }
                }
            }
            
            if(list.get(i).contains(number)){
                return i;
            }
        }
        
        
        return answer;
    }
}