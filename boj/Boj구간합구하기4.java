package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj구간합구하기4 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder output = new StringBuilder();
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(tokens.nextToken());
        int m = Integer.parseInt(tokens.nextToken());
        int arr[] = new int[n+1];
        int sum[] = new int [n+1];
        tokens = new StringTokenizer(input.readLine());
        for(int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
            sum[i] = sum[i-1] + arr[i]; //누적합
        }
        for(int i=0; i<m; i++){
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            int res = sum[b]-sum[a]+arr[a];
            output.append(res).append('\n');
        }
        System.out.print(output);
    }
}
