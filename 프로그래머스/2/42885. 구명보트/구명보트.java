import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        /*
        풀이과정
        1. 오름차순을 한 인원 배열에서 시작과 끝의 인덱스를 갖는 int형 변수를 만듬
        2. index+i의 합이 limit보다 작거나 같을 경우, 둘을 빼줌. 따라서 index += 1;
        3. limit보다 클 경우, 혼자타라고 하고 index는 놔둔채 진행.,,
         */
        Arrays.sort(people);

        int index = 0;
        for(int i = people.length - 1 ;i>=index;i--){
            if(people[index] + people[i] <= limit){
                index+=1;
                answer+=1;
            }
            else answer+=1;
        }
        
        return answer;
    }
}