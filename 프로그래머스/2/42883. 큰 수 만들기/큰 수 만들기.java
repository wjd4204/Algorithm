import java.util.*;

class Solution {
    public String solution(String number, int k) {

        int numSize = number.length() - k; // 남겨야 할 숫자 개수
        char[] result = new char[numSize];
        int index = 0;

        for(int i = 0; i < number.length(); i++) {
            char currentNum = number.charAt(i);

            // 현 currentNum에 대해 index-1에 해당하는 숫자보다 크면 index를 줄이며 제일 큰 수를 넣기
            while (index > 0 && result[index - 1] < currentNum && k > 0) { 
                index--;
                k--; 
            }

            // 현재 문자 추가
            if (index < result.length) {
                result[index++] = currentNum;

            }
        }

        return new String(result);

    }

}