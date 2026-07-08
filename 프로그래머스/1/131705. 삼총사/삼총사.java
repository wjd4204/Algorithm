import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<number.length;i++){
            list.add(number[i]);
        }
        Collections.sort(list);
        
        for(int i=0;i<list.size()-2;i++){
            for(int j=i+1;j<list.size()-1;j++){
                for(int k=j+1;k<list.size();k++){
                    if(list.get(i) + list.get(j) + list.get(k) == 0)
                        answer+=1;
                }
            }
        }
        
        
        return answer;
    }
}
/*
-5, -2, 0, 2, 3
-5, 2, 3
2, 0, -2
어떻게 찾냐?
3개 더하면 되지.
일단 2개로 먼저 더하고, 더한 값의 반대 수의 index가 j보다 크면 answer에 추가
*/