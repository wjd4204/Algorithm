import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static boolean BinarySearch(int num, int[] nCards, int start, int end){
        if(start > end)
            return false;

        int index = (start+end) / 2;
        int mid = nCards[index];
        //System.out.println(num + " " + mid + " " + start + " " + end);
        if(mid == num){
            return true;
        }

        if(mid > num){
            return BinarySearch(num, nCards, start, index-1);
        }
        else if(mid < num){
            return BinarySearch(num, nCards, index+1, end);
        }

        return false;
    }


    // -10, 2, 3, 6, 10
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nCards = new int[n];
        for(int i=0;i<n;i++){
            nCards[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] mCards = new int[m];
        for(int i=0;i<m;i++){
            mCards[i] = sc.nextInt();
        }
        Arrays.sort(nCards);

        int[] answer = new int[m];

        for(int i=0;i<m;i++){
            boolean b = BinarySearch(mCards[i], nCards, 0, nCards.length-1);
            //System.out.println(b);
            if(b == true){
                answer[i] = 1;
            }
            else answer[i] = 0;

            System.out.print(answer[i] + " ");
        }

    }
}
