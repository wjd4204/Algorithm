import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[0], o2[0]));
//        for(int i=0;i<routes.length;i++){
//            System.out.println(routes[i][0] + " " + routes[i][1]);
//        }

        int max = routes[0][1];
        int min = routes[0][0];
        for(int i=0;i<routes.length;i++){
            if(max >= routes[i][1] && min <= routes[i][0]){
                max = routes[i][1];
                min = routes[i][0];
            }
            else if(max < routes[i][0] || min > routes[i][1]){
                max = routes[i][1];
                min = routes[i][0];
                answer+=1;
            }
//            System.out.println("currentIndex : " + routes[i][0] + " " + routes[i][1]);
//            System.out.println(min + " " + max);
        }

        
        return answer;
    }
}