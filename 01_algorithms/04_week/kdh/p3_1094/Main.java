package kdh.p3_1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 총 64cm = 1 0 0 0 0 0 0
        // for문 돌면서 모든 자리의 비트 돌 것임!
        // 만약 set & (1<<x) != 0 라면 result++;
        // 1의 개수가 막대기의 수임!

        // read() — 문자 하나의 ASCII 코드값 반환
        // readLine() — 한 줄 전체를 String으로 반환
        int stick = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i = 0; i < 7; i++){
            if( (stick & (1<<i)) != 0){
                result++;
            }
        }
        System.out.println(result);
    }
}
