import java.util.*;

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
            if (this.t != other.t) return Integer.compare(this.t, other.t);
            // 2. 요청시각(startTime)이 빠른 순
            if (this.startTime != other.startTime) return Integer.compare(this.startTime, other.startTime);
            // 3. 번호(index)가 작은 순
            return Integer.compare(this.index, other.index);
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        int totalResponseTime = 0; // 모든 작업의 (종료시각 - 요청시각) 합산
        int currentTime = 0;      // 현재 시각
        int jobsIdx = 0;          // jobs 배열을 탐색할 인덱스
        int count = 0;            // 처리 완료된 작업 개수
        
        // 모든 작업을 다 처리할 때까지 반복
        while (count < jobs.length) {
            
            // 1. 현재 시각(currentTime) 이하에 들어온 모든 요청을 대기 큐에 집어넣습니다.
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= currentTime) {
                // Job(소요시간, 요청시각, 원본인덱스) 순으로 삽입
                pq.add(new Job(jobs[jobsIdx][1], jobs[jobsIdx][0], jobsIdx));
                jobsIdx++;
            }
            
            // 2. 대기 큐가 비어있다면, 현재 시각에 처리할 수 있는 작업이 없는 상태입니다. (디스크 유휴 상태)
            if (pq.isEmpty()) {
                // 아직 큐에 안 들어온 다음 작업의 '요청 시각'으로 현재 시간을 바로 점프시킵니다.
                currentTime = jobs[jobsIdx][0];
            } 
            // 3. 대기 큐에 작업이 있다면, 우선순위가 가장 높은 작업을 꺼내서 처리합니다.
            else {
                Job currentJob = pq.poll();
                
                // 작업 완료 후 결과 계산: (현재시각 + 소요시간) - 요청시각
                totalResponseTime += (currentTime + currentJob.t) - currentJob.startTime;
                
                // 디스크가 작업을 수행했으므로 현재 시각을 소요시간만큼 더해줍니다.
                currentTime += currentJob.t;
                count++; // 처리 완료 카운트 증가
            }
        }
        
        // 평균 시간을 구하고 소수점 아래는 버림 처리
        return totalResponseTime / jobs.length;
    }
}
/*
우선순위
1. 대기큐가 비어있지 않다면 우선순위가 높은 작업을 대기큐에서 꺼내서 작업 이행
 - 작업 소요시간이 짧은 것, 요청시각이 빠른 것, 번호가 작은 것 순으로 순위가 높음
2. 인터럽트 없음
 - 
*/