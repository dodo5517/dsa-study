package fourth_week.p4_1052

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N: 현재 가진 물병 개수, K: 만들고 싶은 최대 물병 개수
        int N = sc.nextInt();
        int K = sc.nextInt();
        int ans = 0;
        
        // 물병을 합쳤을 때 비트의 갯수가 줄어드는 것을 이용
        // 1의 개수가 K보다 클 때 계속 반복
        while(Integer.bitCount(N) > K) {
            int add = N & -N; // 가장 낮은 비트를 찾아서 그만큼 더함
            ans += add; // 상점에서 사온 물병 개수 누적

            // 비트의 개수가 줄어들면서 물병이 합쳐지게 함.
            N += add;
        }
        System.out.println(ans);
    } 
}