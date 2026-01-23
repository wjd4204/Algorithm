import java.util.*;

class Solution {
    
    public void dfs(int len, char[] chars, int start, StringBuilder sb,  // dfs를 이용하여 각 문자열당 조합을 찾기.
                    Map<String, Integer> map){
        
        if(sb.length() == len){ // 조합에 대한 길이를 만족할 경우 map에 대한 유효성 검증 후 추가
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        
        for(int i = start;i<chars.length;i++){
            sb.append(chars[i]);
            dfs(len, chars, i+1, sb, map);
            sb.deleteCharAt(sb.length() - 1); // ex) 2가지 조합 중 AB가 충족되었다면 AC를 찾아야하므로 맨 마지막 문자를 제거
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
            for(String key : map.keySet()){ // course 요소를 순차 탐색하여 map의 각 key가 문자열의 길이에 만족하는지 판단 후에 max값을 판별
                if(key.length() == len){
                    max = max < map.get(key) ? map.get(key) : max;
                }
            }
            
            //System.out.println(max);
            if(max <= 1)
                continue;
            for(String key : map.keySet()){ // 판별한 max값에 해당하는 조합의 최댓값을 찾음.
                if(map.get(key) == max && key.length() == len){
                    result.add(key);
                }
            }
        }
        
        result.sort(Comparator.comparing(o -> o)); // 오름차순 정렬
        String[] answer = new String[result.size()];
        answer = result.toArray(new String[result.size()]); // list에서 배열 변환 시 (listName).toArray()를 사용하기
        
        
        return answer;
    }
}
