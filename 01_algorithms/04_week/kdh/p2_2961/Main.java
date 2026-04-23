package kdh.p2_2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine()); // 몇 개인지 알고 있음 -> 배열 만들기 가능!
        System.out.println("cnt = " + cnt);

        int[] sour = new int[cnt];
        int[] bitter = new int[cnt];
        int result = Integer.MAX_VALUE; // 최솟값 구해야하니 MAX

        // 한 줄씩 뽑아서 신맛과 쓴맛 저장.
        for(int i = 0; i <cnt; i++){
            String oneLine = br.readLine(); // 한 줄 읽기
            String[] split = oneLine.split(" "); // 공백 기준으로 신맛 쓴맛 나뉨.

            sour[i] = Integer.parseInt(split[0]);
            bitter[i] = Integer.parseInt(split[1]);
        }

        // 비트로 모든 경우의 수 낼 거임.
        // 재료는 적어도 하나 사용하니 1부터.
        for(int mask = 1; mask < (1<<cnt); mask++){
            int totalSour = 1; // 곱해야하니까 1
            int totalBitter = 0;

            // mask로 모든 비트의 경우를 돌아볼 것임!
            // i는 재료임!
            for(int i = 0; i < cnt; i++){
                // 포함 되어있으면
                if( (mask & (1<<i)) != 0 ){
                    // 해당 경우의 신맛들의 곱, 쓴맛들의 합을 구해야 함.
                    totalSour *= sour[i];
                    totalBitter += bitter[i];
                }
            }
            // 다 돌아본 후에
            // 비교 후 작은 값 담기.
            result = Math.min(result, Math.abs(totalSour - totalBitter)); // 차이니까 절댓값으로 감싸야 함!
        }
        System.out.print(result);
    }
}
