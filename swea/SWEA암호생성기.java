package swea;

import java.io.*;
import java.util.*;

public class SWEA암호생성기 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        for (int T = 1; T < 11; T++) {
            int t = Integer.parseInt(input.readLine());
            tokens = new StringTokenizer(input.readLine());
            Queue<Integer> que = new LinkedList<>();
            for (int i = 0; i < 8; i++) {
                que.offer(Integer.parseInt(tokens.nextToken()));
            }
            boolean flag = true;
            while (flag) {
                for (int i = 1; i < 6; i++) {
                    int num = que.poll() - i; //맨 처음거를 빼는거, 자동으로 앞으로 당겨짐
                    if (num <= 0) {
                        que.offer(0); //뒤에 넣기
                        flag = false;
                        break;
                    }
                    else{
                        que.offer(num);
                    }
                }
            }
            output.append("#").append(t).append(" ");
            for(int c: que){
                output.append(c).append(" ");
            }
            output.append('\n');
        }
        System.out.print(output);
    }
}
