import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
            hashMap.put(A[i], 1);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            int num = Integer.parseInt(st.nextToken());
            if(hashMap.get(num) == null){
                 sb.append(0).append("\n");
            }
            else{
                sb.append(1).append("\n");
            }
        }
        System.out.println(sb);

        br.close();
        bw.close();
    }
}
