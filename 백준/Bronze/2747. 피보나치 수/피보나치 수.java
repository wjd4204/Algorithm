import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n+1];
        list[0] = 0;
        list[1] = 1;
        for(int i=2;i<=n;i++){
            list[i] = list[i-1] + list[i-2];
        }
        System.out.println(list[n]);

        br.close();
        bw.close();

    }
}
