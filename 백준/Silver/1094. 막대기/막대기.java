import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        int answer = 1;
        int s = 64;
        int min = 64;
        while(true){
            if(s==x){ // 자른 막대 길이의 합과 입력값이 같으면 break;
                break;
            }
            else if(s > x){ // 같지 않으면 제일 작은 막대를 반으로 자르고 남은 막대 길이의 비교
                min /= 2;
                answer += 1;
                if(s - min >= x) { // 자른 길이가 입력값보다 크거나 같으면 나머지 막대 버리기
                    s -= min;
                    answer -= 1;
                }
            }
            //System.out.println(s);
        }

        System.out.println(answer);
    }
}
