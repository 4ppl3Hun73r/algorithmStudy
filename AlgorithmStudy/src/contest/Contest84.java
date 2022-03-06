package contest;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Contest84 {


    /*
    82번 문제에 스턴 걸려서 잘 못봄
    stack 쓰면 금방 풀림
     */
    public List<Integer> replaceNonCoprimes(int[] nums) {
        /*
        [6,4,3,2,7,6,2]
        Non-Coprime gcd(x,y) > 1

        1. 근접한 수 두개를 본다. 두 수가 Non-Coprime 이면 3번으로 아니면 2번으로
        2. 수가 없으면 종료
        3. 두 수를 지우고 LCM 으로 대체한다.
        4. 1번으로 돌아가시오.
         */
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {

            while (true) {
                int top = stack.isEmpty() ? 1 : stack.peek(); // 1번 근접한 수를 본다
                int gcd = gcd(top, num); // gcd를 구해서 non-coprime 인지 본다.
                if (gcd == 1) { // Coprime
                    break; // 2번 종료
                }
                num = num * (stack.pop() / gcd); // 3번 LCM 대체하기
            }
            stack.push(num);
        }

        return new ArrayList<>(stack);

    }

    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a%b);
        }
    }

    // LCM = (n1 * n2) / GCD


    public static void main(String[] args) {
        Contest84 c = new Contest84();

    }
}
