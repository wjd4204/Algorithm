import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Integer.parseInt(st.nextToken()); // 총 게임 수
        long y = Integer.parseInt(st.nextToken()); // 이긴 게임 수
        int z = (int) (y*100/x);

        // (x+a)*(z+1) = 100(y+a)
        // xz + x + az + a = 100y + 100a
        // xz + x + az - 100y = 99a
        // (99-z)a = x(z+1) - 100
        int answer = (int) Math.ceil((x*(z+1) - 100*y)/(double)(99-z));

        if(x == y || z >= 99)
            answer = -1;
        System.out.println(answer);

        br.close();
        bw.close();
    }
}
