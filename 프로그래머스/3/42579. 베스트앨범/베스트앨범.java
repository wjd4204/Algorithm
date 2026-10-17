import java.util.*;

class Solution {
    
    class Song implements Comparable<Song> {
        int id;
        int play;
        
        public Song(int id, int play){
            this.id = id;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song other){
            if(this.play == other.play){
                return Integer.compare(this.id, other.id);
            }
            
            return Integer.compare(other.play, this.play);
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르 누적합 구하기
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, List<Song>> songMap = new HashMap<>();
        for(int i = 0;i<genres.length;i++){
            String genre = genres[i];
            int play = plays[i];
            
            map.merge(genre, play, Integer::sum); // 장르별 누적합
            
            songMap.putIfAbsent(genre, new ArrayList<>());
            songMap.get(genre).add(new Song(i, play));
        }
        
        // 장르별 노래 정렬하기
        List<String> genreRank = new ArrayList<>(map.keySet());
        genreRank.sort((g1, g2) -> Integer.compare(map.get(g2), map.get(g1))
);
        
        // 내놓기
        List<Integer> list = new ArrayList<>();
        
        for(String st : genreRank){
            List<Song> songs = songMap.get(st);
            Collections.sort(songs);
            
            int count = 0;
            for(Song s : songs){
                list.add(s.id);
                count++;
                if(count==2)
                    break;
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}