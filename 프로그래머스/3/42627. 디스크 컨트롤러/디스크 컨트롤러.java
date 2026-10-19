import java.util.*;

// 4:54
class Solution {
    
    class Job implements Comparable<Job> {
        int t;
        int startTime;
        int index;
        
        public Job(int t, int startTime, int index){
            this.t = t;
            this.startTime = startTime;
            this.index = index;
        }
        
        @Override
        public int compareTo(Job other){
            if(this.t != other.t)
                return Integer.compare(this.t, other.t);
            if(this.startTime != other.startTime)
                return Integer.compare(this.startTime, other.startTime);
            return Integer.compare(this.index, other.index);
        }
    }
    
    public int solution(int[][] jobs) {
        
        Arrays.sort(jobs, (a,b) -> Integer.compare(a[0], b[0]));
        
        int count = 0; // 현재 작업 카운트
        int jobIdx = 0;
        int currentTime = 0;
        int totalResponseTime = 0;
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        while(count < jobs.length){
            
            // 현재 시간보다 count번째 시간이 같거나 작을 동안 진행
            while(jobIdx < jobs.length &&jobs[jobIdx][0] <= currentTime){
                pq.add(new Job(jobs[jobIdx][1], jobs[jobIdx][0], jobIdx));
                jobIdx++;
            }
            
            if(pq.isEmpty()){
                currentTime = jobs[jobIdx][0];
            } else{
                Job jb = pq.poll();
                
                totalResponseTime += (jb.t + currentTime) - jb.startTime; 
                //System.out.println(totalResponseTime);
                currentTime += jb.t;
                
                count++;
            }
        }
        
        return totalResponseTime / jobs.length;
    }
}

/*
1. 우선순위 큐에 넣을 클래스 정의 및 정렬 코드 입력
2. 작업을 진행할 while문 생성
 2-1. currentTime 내에 있는 작업 미시작 리스트를 모두 대기큐에 추가
 2-2. 제어문을 통해 대기큐에 대해 비어있는 여부 확인 후 비어있으면 jobs의 첫 번째 요소까지 시간 당기기
 비어있지 않으면 poll()한 후에 현재 시간에서 소요 시간 더한 후, 해당 요청한 시간 빼기
*/