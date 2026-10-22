import java.util.*;


// 23:41
class Solution {
    
    class WordInfo{
        String word;
        int count;
        
        public WordInfo(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    
    public void bfs(String b, String t, ArrayList<WordInfo> w){
        
        Queue<WordInfo> q = new LinkedList<>();
        q.offer(new WordInfo(b, 0));
        
        WordInfo a;
        boolean[] visited = new boolean[w.size()];
        while(!q.isEmpty()){
            a = q.poll();
            if(a.word.equals(t)){
                answer = a.count;
                break;
            }
            
            int num = 0;
            for(int i=0;i<w.size();i++){
                if(visited[i] == true)
                    continue;
                
                for(int j=0;j<a.word.length();j++){
                    if(a.word.charAt(j) == w.get(i).word.charAt(j))
                        num += 1;
                }
                
                
                if(num == b.length() - 1){ // 1개만 틀리면 담기
                    visited[i] = true;
                    w.get(i).count = a.count + 1;
                    q.offer(w.get(i));
                }
                num = 0;
            }
        }
    }
    
    int answer = 0;

    
    public int solution(String begin, String target, String[] words) {
        
        ArrayList<WordInfo> w = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            w.add(new WordInfo(words[i], 0));
        }
        
        bfs(begin, target, w);
        
        return answer;
    }
}