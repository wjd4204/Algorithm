
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        int[] result = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            result[i] = 1;
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++){
                if(list[i]>list[j]){
                    result[i] = Math.max(result[i], result[j]+1);
                }
            }
            max = Math.max(max, result[i]);
        }
        System.out.println(max);

        br.close();
        bw.close();
    }
}
