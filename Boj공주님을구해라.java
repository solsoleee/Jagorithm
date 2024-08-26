import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj공주님을구해라 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int map[][];
    private static boolean visited[][];
    private static int deltas[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    private static int n,m,t,res, gamRes;
    private static boolean flag;
    private static int gam[];
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        t = Integer.parseInt(tokens.nextToken());
        gam = new int[2];
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            tokens = new StringTokenizer(input.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(tokens.nextToken());
                if(map[i][j]==2){
                    gam[0] =i;
                    gam[1]=j;
                }
            }
        }
        bfs();
        if(flag && map[n-1][m-1]==-1)  {
            res = Math.min(res, gamRes);
            System.out.println(res);
        }
        else System.out.print("Fail");
    }
    private static void bfs(){
        flag  =true;
        Queue<int []> que = new LinkedList<>();
        que.offer(new int[] {0,0,0});
        visited[0][0] = true;
        while(!que.isEmpty()){
            int temp[] = que.poll();
            int x = temp[0];
            int y = temp[1];
            int cnt = temp[2];
            //시간넘으면 바로 종료
            if(cnt > t){
                if(gamRes == 0){
                    flag  =false;
                }
                break;
            }
            //도착하면 멈추기
            if(x == n-1 && y==m-1){
                res = cnt;
                map[n-1][m-1]=-1; //도달한 경우 -1로 바꿔놓기
                break;
            }
            //검이라면
            if(x == gam[0] && y == gam[1]){
                int distance =  (n-1 -x) + (m-1-y);
                 gamRes= cnt+distance;
                if(gamRes > t){
                    flag = false;
                    break;
                }
            }
            for(int d[]:deltas){
                int nx = x+d[0];
                int ny = y+d[1];
                if(nx >=0 && nx<n && ny>=0 && ny<m){
                    if(!visited[nx][ny]){ //방문하지 않았고 벽이 아니여야함
                        if(map[nx][ny]!=1){
                            que.offer(new int[] {nx,ny,cnt+1});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }

    }
}
