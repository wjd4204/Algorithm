import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s  = (long) Double.parseDouble(br.readLine());

        // i와 sum의 합
        long sum = 0;
        int count = 0;
        for(int i=1;;i++){
            s -= i;
            count += 1;
            if(s < 0){
                break;
            }
        }

        System.out.println(count-1);
        br.close();
    }
}
