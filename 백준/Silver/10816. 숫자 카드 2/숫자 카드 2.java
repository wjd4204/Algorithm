import java.io.*;
import java.util.*;

public class Main {

    // -10 -10 2 3 3 6 7 10 10 10
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] nCards = new int[n];
        for(int i=0;i<n;i++){
            nCards[i] = Integer.parseInt(token.nextToken());
            hashMap.put(nCards[i], hashMap.getOrDefault(nCards[i], 0) + 1);
        }
        int m = Integer.parseInt(br.readLine());
        int[] mCards = new int[m];
        token = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            mCards[i] = Integer.parseInt(token.nextToken());
            if(hashMap.get(mCards[i]) == null) sb.append(0).append(" ");
            else sb.append(hashMap.get(mCards[i])).append(" ");
        }
        System.out.println(sb);

        br.close();
        bw.close();
    }
}
