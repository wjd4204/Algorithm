import java.util.*;


class Solution {
    
    static int answer = Integer.MIN_VALUE;
    static boolean[] visited;

    protected static void DFS(int d, int k, int[][] dungeon){

        for(int i=0;i< dungeon.length;i++){
            if(!visited[i] && dungeon[i][0] <= k){
                visited[i] = true;
                DFS(d+1, k-dungeon[i][1], dungeon);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, d);

    }
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        Arrays.sort(dungeons, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]) {
                    //System.out.println(o1[0] + " " + o2[0]);
                    return -1;
                }
                else if(o1[0] == o2[0]){
                    if(o1[1] < o2[1])
                        return -1;
                    return 0;
                }
                else{
                    return 1;
                }
            }
        });

        DFS(0, k, dungeons);
        return answer;
    }
}