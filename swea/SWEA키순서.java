package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA키순서 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static int n,m;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++){
            n = Integer.parseInt(input.readLine());
            m = Integer.parseInt(input.readLine());
            boolean[][] check = new boolean[n][n];
            for(int i=0; i<m; i++) {
                tokens = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(tokens.nextToken())-1;
                int b = Integer.parseInt(tokens.nextToken())-1;
                check[a][b] = true;
            }
            for(int k=0; k<n; k++) {
                for(int i=0; i<n; i++) {
                    for(int j=0; j<n; j++) {
                        if(check[i][k] && check[k][j]) {
                            check[i][j] = true;
                        }
                    }
                }
            }
            int[] cnt = new int[n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(check[i][j] || check[j][i]) {
                        cnt[i] ++;
                    }
                }
            }
            int res =0;
            for(int num : cnt) {
                if(num == n-1) res++;
            }
            output.append("#").append(t).append(" ").append(res).append('\n');
        }
        System.out.print(output);
    }
}