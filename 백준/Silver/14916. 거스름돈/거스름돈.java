import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int answer = n/5;
        if(n%5==0)
            answer = n/5;
        else if((n%5) % 2 == 1){
            int two = n - ((n/5)-1) * 5;
            //System.out.println("two : " + two);
            answer = (n/5)-1 + two/2;
        }
        else{
            int two = n - (n/5) * 5;
            //System.out.println("two : " + two);
            answer = (n/5) + two/2;
        }

        if(n == 1 || n == 3)
            answer = -1;
        System.out.println(answer);


        br.close();
        bw.close();
    }
}
