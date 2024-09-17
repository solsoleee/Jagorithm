package s;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 @author 한소리
 @since 2024. 8. 13.
 @link https://www.acmicpc.net/submit/15649/82417879
 @timecomplex (n!)
 @performance 23408 kb 276 ms
 @category #permutation
 @note */
public class Boj15649_N과M {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();

    private static int arr[];
    private static int n,m;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }

        permutation(0, new int[m], new boolean[n]);
        System.out.print(output);
    }

    private static void permutation(int cnt, int res[], boolean visited[]){
        if(cnt == m){
            for(int i=0; i<res.length; i++){
                output.append(res[i]).append(" ");
            }
            output.append("\n");
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                res[cnt] = arr[i];
                permutation(cnt+1, res, visited);
                visited[i] = false;
            }
        }
    }
}
