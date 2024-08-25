
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        long[] list = new long[101];
        list[1] = 1;
        list[2] = 1;
        list[3] = 1;
        for(int j=4;j<=100;j++){
            list[j] = list[j-2] + list[j-3];
        }
        for(int i=0;i<t;i++){
            
            int n = sc.nextInt();
            System.out.println(list[n]);
        }


    }
}
