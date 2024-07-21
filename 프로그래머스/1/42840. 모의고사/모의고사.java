import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        
        int[][] stu = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        
        int max = Integer.MIN_VALUE;

        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < 3;i++){
            int cnt = 0;
            for(int j = 0;j < answers.length;j++){
                if(answers[j] == stu[i][j % stu[i].length])
                    cnt+=1;
            }
            if(max < cnt)
                max = cnt;
            list.add(cnt);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<3;i++){
            if(list.get(i) == max)
                ans.add(i+1);
        }
        
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}