package chapter13;

import java.io.*;
import java.util.*;

public class 연구소 {


    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static int n,m;
    private static int map[][];
    private static int deltas[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    private static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        tokens =new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        map = new int [n][m];
        for(int i=0;i<n; i++){
            tokens =new StringTokenizer(input.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(tokens.nextToken());
            }
        }
        dfs(0);
        System.out.println(maxSum);

    }

    //벽 3개 세우기
    private static void dfs(int cnt){
        if(cnt == 3){
            int sum = virus();
            maxSum = Math.max(maxSum, sum); //최종으로 가장  0의 개수가 큰거
            return;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1; //벽 세우기
                    dfs(cnt+1);
                    map[i][j] = 0; //벽 취소
                }
            }
        }
    }


    //바이러스 퍼지는 함수
    private static int virus(){
        boolean[][] visited = new boolean[n][m];
        //바이러스 퍼지는 배열은 따로 복사해서 만듦
        int temp[][] = new int [n][m];
        for(int i=0;i<n;i++){
            temp[i] = map[i].clone();
        }

        Queue<int[]> que = new LinkedList<>();
        //바이러스 위치 찾고 que에 넣어두기
        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                if(temp[i][j]==2){
                    que.offer(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        //바이러스 퍼지기
        while(!que.isEmpty()){
            int t[] = que.poll();
            int x = t[0],y = t[1];
            for(int d[] :deltas ){
                int nx = x + d[0];
                int ny = y + d[1];
                if(nx >=0 && nx<n && ny>=0 && ny<m){
                    if(!visited[nx][ny] && temp[nx][ny]==0){
                        temp[nx][ny] = 2;
                        que.offer(new int [] {nx,ny});
                        visited[nx][ny]=true;
                    }
                }
            }
        }
        int sum = safe(temp);
        return sum;
    }
    //안전영역 (0) 을 세는 함수
    private static int safe(int temp[][]){
        int sum = 0 ;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(temp[i][j]==0){
                    sum+=1;
                }
            }
        }
        return sum;
    }
}
