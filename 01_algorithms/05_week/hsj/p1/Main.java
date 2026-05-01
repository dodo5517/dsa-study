import java.io.*;
import java.util.*;

public class Main {

    //처음 - 가 나오고 다른 - 가 나오기 전까지 더해서 뺌
    // 처음은 그냥 더함
    // - 처음 나오면 - 상태로 변환 이전까지 빼야 하는 수들 있으면 뺌
    // + 면 - 상태가 아니면 그냥 누적, - 상태면 빼야하는 수에 누적
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = 0;
        List<String> arr = new ArrayList<>();

        // 숫자와 연산자 단위로 끊어 저장하기
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                num.append(s.charAt(i));
            }
            else {
                arr.add(num.toString());
                num = new StringBuilder();
                arr.add(String.valueOf(s.charAt(i)));
            }
        }
        arr.add(num.toString());

        int sum = 0;
        boolean isMinus = false;
        for (int i=0;i<arr.size();i++){
            if (arr.get(i).equals("-")){
                isMinus = true;
                answer-=sum;
                sum = 0;
            }
            else if (arr.get(i).equals("+")) continue;
            else {
                if (isMinus){
                    sum+=Integer.parseInt(arr.get(i));
                }
                else{
                    answer+=Integer.parseInt(arr.get(i));
                }
            }
        }
        if (isMinus){
            answer-=sum;
        }

        System.out.println(answer);

    }
}