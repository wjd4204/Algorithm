import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String answer = "";

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            int count = 0;
            for(int j=i;j<str.length();j++){
                if(str.charAt(j) != c)
                    break;
                count+=1;
            }
            if(c == '.'){
                for(int k=0;k<count;k++)
                    answer+='.';
            }
            else if(c == 'X'){
                if(count % 2 == 1){
                    answer = "-1";
                    break;
                }
                for(int k=0;k<count/4;k++)
                    answer+="AAAA";
                for(int k=0;k<(count%4)/2;k++)
                    answer+="BB";
            }
            i += count -1;
        }

        System.out.println(answer);
    }
}
