import java.util.*;

class Solution {

    static int answer = Integer.MAX_VALUE;
    private static int BFS(int a, int b, int[][] wires, int n){

        int cnt = 1;
        int[] v = new int[n+1];

        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        v[a] = 1;

        while(!q.isEmpty()){
            int num = q.poll();

            for(int i=0;i<n-1;i++){
                int n1 = wires[i][0];
                int n2 = wires[i][1];
                if(n1 == b || n2 == b){
                    continue;
                }
                if(v[n1] == 0 && n2 == num){
                    q.add(n1);
                    v[n1] = 1;
                    cnt += 1;
                }
                else if(v[n2] == 0 && n1 == num){
                    q.add(n2);
                    v[n2] = 1;
                    cnt += 1;
                }
            }
        }

        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        
        for(int i=0;i<n-1;i++){
            int first = BFS(wires[i][0], wires[i][1], wires, n);
            int sec = BFS(wires[i][1], wires[i][0], wires, n);
            //System.out.println(first + " " + sec);
            answer = Math.min(answer, Math.abs(first-sec));
        }
        
        return answer;
    }
}