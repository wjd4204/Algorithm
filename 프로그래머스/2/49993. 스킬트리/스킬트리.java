import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<skill.length();i++){
            q.add(skill.charAt(i));
        }
        
        String str = "";
        for(int i=0;i<skill_trees.length;i++){
            int flag = 0;
            str = "";
            for(int j=0;j<skill_trees[i].length();j++){
                if(q.contains(skill_trees[i].charAt(j)))
                    str += skill_trees[i].charAt(j);
            }
            Queue<Character> q1 = new LinkedList<>(q);
            //System.out.println("str : " + str);
            for(int j=0;j<str.length();j++){
                if(!q1.peek().equals(str.charAt(j))){
                    flag = 1;
                    break;
                }
                q1.poll();
            }
            System.out.println();
            if(flag == 0)
                answer+=1;
        }
        
        
        return answer;
    }
}