package swea;

import java.io.*;
import java.util.*;

public class SWEA햄버거다이어트 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder output = new StringBuilder();
    private static int n,l;
    private static int max_value, total;
    private static int t_arr[], k_arr[];
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++){
            max_value = Integer.MIN_VALUE;
            tokens = new StringTokenizer(input.readLine());
            n = Integer.parseInt(tokens.nextToken());
            l = Integer.parseInt(tokens.nextToken());
            visited = new boolean[n];
            t_arr = new int[n];
            k_arr = new int[n];
            for(int i =0; i<n; i++){ //재료 정보
                tokens = new StringTokenizer(input.readLine());
                t_arr[i] = Integer.parseInt(tokens.nextToken());
                k_arr[i] = Integer.parseInt(tokens.nextToken());
            }
            subSet(0);
            output.append("#").append(t).append(" ").append(max_value);
            output.append('\n');
        }
        System.out.print(output);
    }
    private static void subSet(int cnt){

        if(cnt == n) {
            if(check()){
                max_value = Math.max(max_value, total);
            }
            return;
        }
        visited[cnt] = true;
        subSet(cnt+1);

        visited[cnt] = false;
        subSet(cnt+1);
    }

    private static boolean check(){
        int kal = 0;
        total =0;
        for (int i=0; i<n; i++){ //선택 된거 중에서 칼로리 계산
            if(visited[i]){
                kal += k_arr[i];
                total += t_arr[i]; //선호도 점수
            }
        }
        if(kal > l){ //칼로리가 넘어가면 X
            return false;
        }
        return true;
    }

}
