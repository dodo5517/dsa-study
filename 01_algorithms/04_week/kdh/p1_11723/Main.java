package kdh.p1_11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(    String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(br.readLine()); // 첫 줄에 총 개수 있음.
        int set = 0;

        for(int i = 0; i < cnt; i++){
            String oneLine = br.readLine(); // 한 줄 읽기
            String[] split = oneLine.split(" "); // 공백을 기준으로 연산과 x를 구분
            String cmd = split[0]; // 앞이 연산자

            if(cmd.equals("add")){
                int x = Integer.parseInt(split[1]);
                // x에 있다면 무시, 없다면 x 추가
                if( (set & (1<<x)) == 0 ){
                    set = set | (1<<x); // x 추가
                }
            }
            else if(cmd.equals("remove")){
                int x = Integer.parseInt(split[1]);
                // x에 없다면 무시, 있다면 x 삭제
                if( (set & (1<<x)) != 0 ){
                    set = set & ~(1<<x); // x 삭제
                }
            }
            else if(cmd.equals("check")){
                int x = Integer.parseInt(split[1]);
                // x에 있다면 1 출력
                if( (set & (1<<x)) != 0 ){
                    sb.append(1).append("\n");
                } else { // 없다면 2 출력
                    sb.append(2).append("\n");
                }
            }
            else if(cmd.equals("toggle")){
                int x = Integer.parseInt(split[1]);
                // x에 있다면 삭제, 없다면 추가
                set = set ^ (1<<x); // XOR(=서로 다르면 1)
            }
            else if(cmd.equals("all")){
                for(int j = 1; j <= 20; j++){
                    set = set | (1<<j); // 전부 1로
                }
            }
            else if(cmd.equals("empty")){
                // 공집합으로
                set = 0;
            }
        }

        System.out.println(sb);
    }
}
