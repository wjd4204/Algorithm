class Solution
{
    public int isOdd(int n){
        if(n % 2 == 1){
            return (n / 2) + 1;
        }
        return n / 2;
    }
    
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        
        if (a > b){
            int temp = a;
            a = b;
            b = temp;
        }
        
        System.out.println(a);
        while(true){
            if(a + 1 == b && a % 2 == 1)
                break;
            a = isOdd(a);
            b = isOdd(b);
            answer += 1;
        }

        return answer;
    }
}