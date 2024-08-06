import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class chapter4_2 {
    private static int direction;
    public static void main(String[] args) throws NumberFormatException, IOException {
        int [][] deltas = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int map[][] = new int[r][c];
        boolean visited[][] = new boolean [r][c];

        int x = sc.nextInt();
        int y = sc.nextInt();
        int direction = sc.nextInt();
        for(int i=0; i<r; i++){
            for (int j=0; j<c; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int count=1;
        int turn_count=0;
        while(true){

            if(turn_count==4){
                x-=1;
                y-=1;
                if(x<0 || x>=r || y<0 || y>=c || map[x][y]==1 || !visited[x][y]){ //바다이면 움직임을 멈추기
                    break;

                }
            }
            int nx = x + deltas[direction][0]; //현재 방향
            int ny = y + deltas[direction][1];
            System.out.println(nx +" " + ny + " " +direction);
            if(nx<0 || nx>=r || ny<0 || ny>=c || map[nx][ny]==1 || visited[nx][ny]){
                direction=turn(direction);
                turn_count++;
                continue;
            }

            visited[nx][ny]=true; //전진
            count+=1;
            x = nx;
            y = ny;
            turn_count=0;

//            if(nx >=0 && nx<r && ny>=0 && ny<c && map[nx][ny]!=1){ //범위 안에 들어오고 범위가 아니면
//                if(!visited[nx][ny]) { //가보지 못한 곳이 있으면
//                    visited[nx][ny]=true; //전진
//                    count+=1;
//                    x = nx;
//                    y = ny;
//                }
//        }

        }
        System.out.println(count);

//        Queue <int []> que = new LinkedList<>();
//        que.offer(new int[] {x,y});
//        visited[x][y]=true;
//        while(!que.isEmpty()){
//            int t[]=que.poll();
//            x = t[0];
//            y = t[1];
//
//            for(int i=0; i<4; i++){
//                int nx = x + deltas[i][0]; //현재 방향
//                int ny = y + deltas[i][1];
//
//                if(nx >=0 && nx<r && ny>=0 && ny<c && map[nx][ny]!=1){ //범위 안에 들어오고 범위가 아니면
//                    if(!visited[nx][ny]){ //가보지 못한 곳이 있으면
//                        que.offer(new int[]{nx,ny});
//                        visited[nx][ny]=true; //가봤다고 표시
//                        count+=1;
//                    }
//            }

        }


    private static int turn (int d){
        d = (d+1)%4;
        return d;
    }
}
