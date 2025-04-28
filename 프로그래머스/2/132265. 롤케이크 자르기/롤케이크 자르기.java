import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for(int i=0;i<topping.length;i++){
            hashMap2.put(topping[i], hashMap2.getOrDefault(topping[i], 0) + 1);
        }
        
        for(int i=0;i<topping.length;i++){
            if(hashMap2.containsKey(topping[i]))
                hashMap2.put(topping[i], hashMap2.get(topping[i]) - 1);
            if(hashMap2.get(topping[i]) == 0){
                hashMap2.remove(topping[i]);
            }
            
            hashMap1.put(topping[i], hashMap1.getOrDefault(topping[i], 0) + 1);
            //System.out.println(hashMap1.size() + " " + hashMap2.size());
            if(hashMap1.size() == hashMap2.size())
                answer+=1;
        }
        
        
        return answer;
    }
}