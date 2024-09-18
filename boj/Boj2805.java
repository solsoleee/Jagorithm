package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2805 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n,m;
    private static int tree[];
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        tree = new int [n];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++) {
            tree[i] = Integer.parseInt(tokens.nextToken());
        }
        Arrays.sort(tree);

        int res = 0;
        int start  = 0;
        int end = tree[n-1];

        while(start <= end) {
            int mid = ( start + end ) / 2;
            long sum =0;
            for(int i=0; i<n; i++) {
                if(tree[i] > mid) {
                    sum += (long)(tree[i] - mid);
                }
            }
            if(sum >= m) {
                res = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        System.out.print(res);
    }
}
