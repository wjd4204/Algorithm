class Solution {
    public int[] solution(int n) {
        int num = 0;
        for(int i=1;i<=n;i++){
            num += i;
        }
        
        int[] answer = new int[num];
        int[] visited = new int[num];
        
        int start = 1;
        int end = n;
        
        int direction = 1;
        int index = 0;
        int cnt = 1;
        while(n > 0){
            //System.out.println(n + " " + direction);
            if(direction % 3 == 1){
                for(int i=start;i<=end;i++){
                    answer[index] = cnt++;
                    visited[index] = 1;
                    if(i != end)
                        index += i;
                }
                index += 1;
                start += 1;
            } else if(direction % 3 == 2){
                while(true){
                    if(index >= num){
                        index-=1;
                        break;
                    }
                    if(visited[index] == 1){
                        index -= 1;
                        break;
                    }
                    answer[index++] = cnt++;
                }
                index -= end--;
            } else {
                for(int i=end;i>=start;i--){
                    //System.out.println(index + " " + visited[index]);
                    if(visited[index] == 0){
                        answer[index] = cnt++;
                        visited[index] = 1;
                        if(i != start){
                            index -= i;
                        }
                    } else break;
                }
                index += start++;
            }
            direction += 1;
            n-=1;
        }
        
        return answer;
    }
}