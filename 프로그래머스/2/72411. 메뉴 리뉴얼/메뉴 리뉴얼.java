import java.util.*;

class Solution {
    
    public void dfs(int len, char[] chars, int start, StringBuilder sb, 
                    Map<String, Integer> map){
        
        if(sb.length() == len){
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for(int i = start;i<chars.length;i++){
            sb.append(chars[i]);
            dfs(len, chars, i+1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        
        List<String> s = Arrays.asList(orders);
        s.sort(Comparator.comparing(o -> o.length()));
        
        Map<String, Integer> map = new HashMap<>();
        for(String ss : s){
            for(int i=0;i<course.length;i++){
                char[] cc = ss.toCharArray();
                Arrays.sort(cc);
                dfs(course[i], cc, 0, new StringBuilder(), map);
            }
        }
        
        //System.out.println(map);
        List<String> result = new ArrayList<>();
        for(int i=0;i<course.length;i++){
            int len = course[i];
            int max = -1;
            for(String key : map.keySet()){
                if(key.length() == len){
                    max = max < map.get(key) ? map.get(key) : max;
                }
            }
            
            //System.out.println(max);
            if(max <= 1)
                continue;
            for(String key : map.keySet()){
                if(map.get(key) == max && key.length() == len){
                    result.add(key);
                }
            }
        }
        
        result.sort(Comparator.comparing(o -> o));
        String[] answer = new String[result.size()];
        answer = result.toArray(new String[result.size()]);
        
        
        return answer;
    }
}