import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<String> list = new ArrayList<>();

        sc.nextLine();
        for(int i=0;i<n;i++){
            String str = sc.nextLine();
            if(!list.contains(str)) // 중복되는 list가 존재할 경우 add를 하지 않음.
                list.add(str);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) // 문자열의 길이 비교
                    return 1;
                else if(o1.length() == o2.length()){ // 두 문자열의 길이가 같으면 compareTo를 사용해 알파벳비교
                    return o1.compareTo(o2);
                }

                return -1;
            }
        });

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
