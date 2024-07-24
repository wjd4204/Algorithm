import java.util.*;

class Solution {
    
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;

    private static void DFS(String str, String word){

        for(int i=0;i<word.length();i++){
            if(visited[i] == true){
                continue;
            }
            String s = str + word.charAt(i);
            if(visited[i] == false) {
                visited[i] = true;
                if(!list.contains(Integer.parseInt(s)))
                    list.add(Integer.parseInt(s));
                DFS(s, word);
                visited[i] = false;
            }
        }
    }

    private static int isPrime(int n){

        for(int i=2;i<=n/2;i++){
            if(n%i == 0)
                return 0;
        }

        return 1;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];

        DFS("", numbers);
        //System.out.println(list);
        for(int i=0;i<list.size();i++){
            if(list.get(i) == 1 || list.get(i) == 0)
                continue;
            answer += isPrime(list.get(i));
        }
        
        return answer;
    }
}