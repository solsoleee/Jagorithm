package s;

import java.io.*;
import java.util.*;

/**
 @author 한소리
 @since 2024. 8. 13.
 @link https://www.acmicpc.net/submit/18429/82420196
 @timecomplex (n!)
 @performance 14904kb 144ms
 @category #permutation
 @note */

public class Boj18429 {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int kit[]; //중량 //
    private static int arr[]; //최종 순서
    private static boolean visited[];
    private static int n,k;
    private static int res;

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());

        kit = new int [n];
        arr = new int [n];
        visited = new boolean [n];

        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++){
            kit[i] = Integer.parseInt(tokens.nextToken());
        }
        permutation(0);
        System.out.println(res);

    }
    private static void permutation(int cnt){
    //하루마다 k가 줄고, arr[i] 만큼 얻는다.
        if(cnt == n){
            //초기값 설정
            boolean flag=true;
            int total =500;
            //하루에 500이상이 되지 않으면 res개수 세지 않음
            for(int i=0; i<arr.length; i++){
                total +=( arr[i] - k);
                if(total < 500){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res++; // 500 넘게 되는 경우의 수 더하기
            }
            return;
        }
        for(int i=0; i<kit.length; i++){
            if(!visited[i]){
                arr[cnt] = kit[i];
                visited[i] = true;
                permutation(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
