import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] stu = new int[n][5];
        int answer = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<5;j++){
                stu[i][j] = sc.nextInt();
            }
        }

        int[] match = new int[n]; // n명의 학생들이 각각 다른 학생과 같은 반이었던 횟수
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){ //i번 학생은
            for(int j=0;j<n;j++){ // j번 학생과 매칭이 되었으면 +1
                int cnt = 0;
                if(i == j) // i와 j가 같은 학생이면 속함을 따질 필요 없으므로 생략
                    continue;
                while(cnt < 5){ // 만일 한 번이라도 j번째와 같은 반이었다면 match[i]에 +1을 하고 break. 이미 한 번으로 조건이 만족하기 때문이다.
                    if(stu[i][cnt] == stu[j][cnt]){
                        match[i] += 1;
                        break;
                    }
                    cnt+=1;
                }
            }
            if(max < match[i]){ // 지금까지 제일 많은 횟수의 학생보다 i번째 학생이 더 많이 같은 반이었던 친구가 많으면 교환하고
                answer = i+1; // answer에 i번째 학생 저장
                max = match[i];
            }

        }

//        for(int i : match)
//            System.out.println(i);

        System.out.println(answer);

    }
}
