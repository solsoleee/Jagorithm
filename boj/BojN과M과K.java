package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BojN과M과K {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder output = new StringBuilder();
    private static int n,m,k, res;
    private static int arr[][];
    private static boolean visited[][];
    private static int max_value = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        tokens =new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            tokens =new StringTokenizer(input.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        combi(0,0,0);
        System.out.println(max_value);
    }

    private static void combi(int start, int cnt, int sum){
        if(cnt == k){
            max_value = Math.max(max_value,sum);
            return;
        }
        //조합사용
        for(int i=0; i<n*m; i++){
            int row = i/m;
            int col = i%m;

            //근처에 있는지 확인
            if(row-1 >=0 && visited[row-1][col] ||
                    col-1 >=0 && visited[row][col-1] ||
                    col+1  <m && visited[row][col+1] ||
                    row+1  <n && visited[row+1][col])
                continue;


            if (!visited[row][col]){ //방문하지 않았으면
                visited[row][col] = true;//방문
                combi(i+1, cnt+1, sum+arr[row][col]);
                visited[row][col] = false;//방문

            }

        }
    }
}
