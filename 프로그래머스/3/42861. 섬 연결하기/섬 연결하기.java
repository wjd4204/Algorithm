import java.util.*;

class Solution {
    
    static int[] parent;
    static void union(int a, int b){
        // a와 b의 부모 노드 찾기
        a = find(a);
        b = find(b);

        //대소비교하여 작은 수가 큰 수의 부모노드가 됨.
        if(a>b)
            parent[a] = b;
        else parent[b] = a;
    }
    static int find(int x){
        if(parent[x] == x)
            return x;
        else return find(parent[x]);
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;

        // 간선을 기준으로 오름차순 정렬 실행
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        for(int i=0;i<costs.length;i++){
            System.out.println(costs[i][0] + " " + costs[i][1] + " " + costs[i][2]);
        }

        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        // 크루스칼 알고리즘 사용하기
        for(int i=0;i<costs.length;i++){

            // i번째 노드들의 부모노드가 같지 않으면 다른 집합임을 의미.
            if(find(costs[i][0]) != find(costs[i][1])){
                // 엮어도 순환이 되지 않는다면 하나의 집합으로 만들기
                union(find(costs[i][0]), find(costs[i][1]));
                answer += costs[i][2];
                continue;
            }
        }
        
        return answer;
    }
}
