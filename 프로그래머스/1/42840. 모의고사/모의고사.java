import java.util.*;

class Solution {
    
    int[] stu1 = {1, 2, 3, 4, 5};
    int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        
        int[] num = {0, 0, 0};
        int count = 0;
        
        for(int i=0;i<answers.length;i++){
            int ans = answers[i];
            
            if(stu1[i%stu1.length] == ans){
                num[0] += 1;
            }
            if(stu2[i%stu2.length] == ans){
                num[1] += 1;
            }
            if(stu3[i%stu3.length] == ans){
                num[2] += 1;
            }
            
        }
        
        count = Math.max(num[0], num[1]);
        count = Math.max(count, num[2]);
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<3;i++){
            if(count == num[i])
                list.add(i+1);
        }
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}