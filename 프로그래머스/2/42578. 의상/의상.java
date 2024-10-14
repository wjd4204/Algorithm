import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> sort = new HashMap<>();

        for(int i=0;i< clothes.length;i++){
            if(!sort.containsKey(clothes[i][1])){
                sort.put(clothes[i][1], 1);
            }
            else{
                Integer num = sort.get(clothes[i][1]);
                sort.replace(clothes[i][1], num+1);
            }
        }

        int result = 1;
        for(String key : sort.keySet()){
            result = result * (sort.get(key)+1);
        }
        
        return result-1;
    }
}