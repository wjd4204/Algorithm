import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        List<String[]> list = Arrays.asList(book_time);

        list.sort(Comparator.comparing(o -> o[0]));
        
        // for(int i=0;i<list.size();i++){
        //     String[] str = list.get(i);
        //     System.out.print(str[0] + " " + str[1] + " / ");
        // }

        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for(String[] ss : list){
            String[] starts = ss[0].split(":");
            String[] ends = ss[1].split(":");
            
            int start = Integer.parseInt(starts[0]) * 60 + Integer.parseInt(starts[1]);           
            int end = Integer.parseInt(ends[0]) * 60 + Integer.parseInt(ends[1]) + 10;
            if(q.isEmpty()){
                answer++;
                q.add(new int[]{start, end});
                continue;
            }
            
            int[] s = q.peek(); // 만약 현재 대상 입실이 큐에 있는 퇴실보다 빠르면 넣기
            //System.out.println(ss[0] + ":" + start + " " + s[1]);
            if(start < s[1]){
                answer++;
                q.add(new int[]{start, end});
            } else { // 현재 대상 입실이 추출한 퇴실보다 느리면 이 다음에 넣기
                q.poll();
                q.add(new int[]{start, end});
            }
        }
        
        
        return answer;
    }
}
// 정렬
// ["14:10", "19:20"], ["14:20", "15:20"],  ["15:00", "17:00"],
// ["16:40", "18:20"],["18:20", "21:20"]
// 큐를 구성하여 끝난 시간이 빠른 순으로 정렬