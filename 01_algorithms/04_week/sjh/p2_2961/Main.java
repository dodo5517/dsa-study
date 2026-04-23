package fourth_week.p2_2961

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 1. 재료의 개수 N
        long[] sour = new long[N]; // 신맛 배열 (곱하기용)
        long[] bitter = new long[N]; // 쓴맛 배열 (더하기용)

        for (int i = 0; i < N; i++) {
            sour[i] = sc.nextLong();
            bitter[i] = sc.nextLong();
        }

        long minDiff = Long.MAX_VALUE; // 2. 최소 차이를 저장할 변수

        // 3. 비트마스킹으로 모든 부분 집합을 탐색
        // 1 << N 은 2의 N제곱이야. i는 1부터 (2^N - 1)까지
        // 재료를 적어도 하나 써야하기 때문에 i = 1
        for (int i = 1; i < (1 << N); i++) {
            long sSum = 1, bSum = 0; // 신맛은 곱해야 하니까 초기값 1, 쓴맛은 더해야 하니까 초기값 0
            
            // 4. i라는 숫자의 비트를 하나씩 뜯어보면서 어떤 재료가 포함됐는지 확인
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    // (i & (1 << j))가 0이 아니라는 건, i의 j번째 비트가 1아님
                    sSum *= sour[j]; // 신맛은 곱하기
                    bSum += bitter[j]; // 쓴맛은 더하기
                }
            }
            
            // 5. 이번 조합의 (신맛 - 쓴맛) 차이를 구해서 최솟값을 갱신
            minDiff = Math.min(minDiff, Math.abs(sSum - bSum));
        }
        System.out.println(minDiff);
    }
}