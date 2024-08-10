import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int answer = Math.min(x, y);
        answer = Math.min(answer, w-x);
        answer = Math.min(answer, h-y);

        System.out.println(answer);

    }
}
