import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        
        // 가로든 세로든 대소비교를 통해 긴쪽과 짧은쪽을 분리
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0] > sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }

        // 가로와 세로를 저장하는 List를 각각 만들고 sort를 이용해 내림차순으로 만들기
        List<Integer> width = new ArrayList<>();
        List<Integer> length = new ArrayList<>();
        for(int[] i : sizes){
            width.add(i[0]);
            length.add(i[1]);
        }
        Collections.sort(width, Comparator.reverseOrder());
        Collections.sort(length, Comparator.reverseOrder());
        
        // 첫 번째 값들이 가장 크므로 두 List의 첫 번째 값의 곱을 저장하여 반환
        answer = width.get(0) * length.get(0);
        return answer;
    }
}