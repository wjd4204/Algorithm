import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> big = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> small = new PriorityQueue<>();

        for(int i=0;i< operations.length;i++){
            String[] st = operations[i].split(" ");
            int num = Integer.parseInt(st[1]);
            //System.out.println("st[0] : " + st[0] + " st[1] : " + num);
            if(st[0].equals("I")){
                big.offer(num);
                small.offer(num);
            }
            else{
                if(big.isEmpty() && small.isEmpty())
                    continue;
                if(num == 1){
                    int n = big.poll();
                    small.remove(n);
                }
                else{
                    int n = small.poll();
                    big.remove(n);
                }
            }
//            System.out.println("big : " + big);
//            System.out.println("small : " + small);
        }

        int[] answer = new int[2];
        if(big.isEmpty() && small.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = big.poll();
            answer[1] = small.poll();
        }
        
        return answer;
    }
}