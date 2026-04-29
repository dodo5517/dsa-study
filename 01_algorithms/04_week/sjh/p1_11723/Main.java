package fourth_week.p1_11723


import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int S = 0;
        StringBuilder sb = new StringBuilder();

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            
            // x가 없는 명령을 선언
            // 연산 기호는 몰라서 Geminai를 그냥 카피
            int x = 0;

            switch (op) {

                // S에 x를 추가
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    S |= (1 << x);
                    break;

                // S에서 x를 제거
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    S &= ~(1 << x);
                    break;

                // S에 x가 있으면 1을, 없으면 0을 출력
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append((S & (1 << x)) != 0 ? 1 : 0).append("\n");
                    break;

                // S에 x가 있으면 x를 제거하고, 없으면 x를 추가
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    S ^= (1 << x);
                    break;

                // S를 {1, 2, ..., 20} 으로 바꿈
                case "all":
                    S = (1 << 21) - 1;
                    break;

                // S를 공집합으로 바꿈
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}