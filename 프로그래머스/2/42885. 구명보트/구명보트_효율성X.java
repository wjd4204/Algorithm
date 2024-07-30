import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i : people){
            list.add(i);
        }
        Collections.sort(list);

      /*
      - 본 문제는 List로 구현한 문제로서 본문의 해결과정과 일치하나 시간복잡도가 O(n^2)으로 표기되어
      시간초과 오류가 발생함.
      - 시간복잡도를 제외했을때는 이런 식으로도 풀 수 있음을 증명하기 위함.
      */
        while(!list.isEmpty()){
            int num = list.remove(0);
            int index = list.size() - 1;
//            System.out.println(match);
            Boolean two = false;
            while(index >= 0){
                //System.out.println(num + " " + list.get(index));
                if(limit >= num + list.get(index)){
                    list.remove(index);
                    two = true;
                    answer+=1;
                    break;
                }
                index--;
            }
            if(!two)
                answer+=1;
        }
        
        return answer;
    }
}
