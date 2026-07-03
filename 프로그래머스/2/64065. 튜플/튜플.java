import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.substring(2, s.length()-2).replace("},{", "-");

        String[] str = s.split("-");
    
        Arrays.sort(str, Comparator.comparingInt(String::length));
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<str.length;i++){
            String[] check = str[i].split(",");
            
            for(int j=0;j<check.length;j++){
                int num = Integer.parseInt(check[j]);
                
                if(!list.contains(num))
                    list.add(num);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0;i< answer.length;i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
/*
작은 배열부터 차례를 맞추어가는 문제


*/