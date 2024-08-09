package chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Chapter13_1 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer output = new StringBuffer();
    private static int n,m,k,x;
    private static int arr[][];
    private static boolean visited[];
    private static StringTokenizer tokens;
    private static boolean flag;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());
        x = Integer.parseInt(tokens.nextToken());
        arr = new int [n][n];
        visited = new boolean[n];

        for(int i=0; i<m; i++ ){
            tokens = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());

            arr[a-1][b-1] =1;
            arr[b-1][a-1] =1;
        }
        flag = true;
        bfs(x-1, 0);

        if(flag){
            System.out.println(-1);
        }
        else{
            System.out.print(output);
        }
    }

    private static void bfs(int x, int count){

        Queue <int []> que = new LinkedList<>();
        que.offer(new int[] {x, count});
        visited[x]=true;
        while(!que.isEmpty()) {

            int t[] = que.poll();

            int nx = t[0];
            int cnt = t[1];
            if(!flag && cnt>k){
                break;
            }

            if (cnt==k){
                output.append(nx+1).append('\n');
                flag = false;
            }
            for(int i=0; i<n; i++){
                if(arr[nx][i]==1 && !visited[i]){
                    que.offer(new int[] {i, cnt+1});
                    visited[i] = true;
                }
            }

        }
    }
}
