import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        Map<String, String> users = new HashMap<>();
        
        for(String s : record) {
            String[] str = s.split(" ", s.length());
            
            if(str[0].equals("Enter")) {
                if(!users.containsKey(str[1])){
                    users.put(str[1], str[2]);
                } else {
                    users.replace(str[1], str[2]);
                }
            } else if(str[0].equals("Change")) {
                users.replace(str[1], str[2]);
            }
        }
        
        //System.out.println(users);
        List<String> list = new ArrayList<>();
        for(String s : record){
            String[] str = s.split(" ", s.length());
            String nickname = users.get(str[1]);
            //System.out.println("nickname : " + nickname);
            
            if(str[0].equals("Enter")) {
                list.add(nickname + "님이 들어왔습니다.");
            } else if(str[0].equals("Leave")) {
                list.add(nickname + "님이 나갔습니다.");
            }
        }
        
        //System.out.println(list);
        answer = list.toArray(new String[list.size()]);
        
        return answer;
    }
}