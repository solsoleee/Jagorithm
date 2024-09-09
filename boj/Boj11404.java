package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11404 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n,m;
    static long distance[][];

    public static void main(String[] args) throws IOException {
    n = Integer.parseInt(input.readLine());
    m = Integer.parseInt(input.readLine());
    distance = new long [n+1][n+1];
    int INF = Integer.MAX_VALUE;
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=n; j++) {
            if(i!=j)  distance[i][j] = INF;
        }
    }

    for(int i=0; i<m; i++){
        tokens = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(tokens.nextToken());
        int b = Integer.parseInt(tokens.nextToken());
        int c = Integer.parseInt(tokens.nextToken());
        if(distance[a][b] > c) distance[a][b] = c;
    }

    for(int k=1; k<=n; k++) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
            }
        }
    }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(distance[i][j] == INF) System.out.print(0 + " ");
                else{
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}
