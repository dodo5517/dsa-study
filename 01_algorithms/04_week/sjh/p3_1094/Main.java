package fourth_week.p3_1094

import java.util.*;

// 이진법의 원리를 이용하면 X를 만들기 위한 막대 개수는 X의 비트 중 1의 개수와 같음.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Integer.bitCount(sc.nextInt())); // 이진법 내장함수
    }
}