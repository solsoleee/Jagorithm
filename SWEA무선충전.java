import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA무선충전 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static int n,m,bcCnt;
    private static int[] playerA, playerB; //a와 b의 현재 좌표값
    private static int[] pathA, pathB; //a와 b의 가야할 길
    private static int[][] bc;
    // 그대로, 상, 우, 하, 좌
    private static int dx[] = {0, 0, 1, 0, -1};
    private static int dy[] = {0, -1, 0, 1, 0};
    public static void main(String[] args) throws IOException {

        int T =Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++){
            tokens = new StringTokenizer(input.readLine());
            m = Integer.parseInt(tokens.nextToken());
            bcCnt = Integer.parseInt(tokens.nextToken());

            playerA = new int[2];
            playerB = new int[2];
            playerA[0] = playerA[1] = 1;
            playerB[0] = playerB[1] = 10;
            bc = new int [bcCnt][4];
            pathA = new int [m+1];
            pathB = new int [m+1];

            StringTokenizer tokenA = new StringTokenizer(input.readLine());
            StringTokenizer tokenB = new StringTokenizer(input.readLine());
            for(int i=1; i<=m; i++){
                pathA[i] = Integer.parseInt(tokenA.nextToken());
                pathB[i] = Integer.parseInt(tokenB.nextToken());
            }

            for (int i = 0; i < bcCnt; i++) {
                tokens = new StringTokenizer(input.readLine());
                bc[i][0] = Integer.parseInt(tokens.nextToken()); // x
                bc[i][1] = Integer.parseInt(tokens.nextToken()); // y
                bc[i][2] = Integer.parseInt(tokens.nextToken()); // 거리
                bc[i][3] = Integer.parseInt(tokens.nextToken()); // 충전량
            }

            //매 시간마다 최대 합 더하기
            int totalSum = 0;
            for(int i=0; i<=m; i++){
                //위치 업데이트
                playerA[0] += dx[pathA[i]];
                playerA[1] += dy[pathA[i]];
                playerB[0] += dx[pathB[i]];
                playerB[1] += dy[pathB[i]];

                //현재 시간에서 최대합 더하기
                totalSum += combi();
            }
            output.append("#").append(t).append(" ").append(totalSum).append('\n');
        }
        System.out.print(output);
    }
    //맨해튼 거리에 들어오는 지 여부
    //bc와 현재 플레이어의 좌표값
    private static int check(int idx, int x, int y){
        int distance = Math.abs(bc[idx][0] - x) + Math.abs(bc[idx][1] - y);
        if(distance <= bc[idx][2]) return bc[idx][3];
        return 0; //범위에 없으면 0
    }

    // 모든 충전소 조합 탐색
    private static int combi() {
        int max_val = 0; //매 시간에 대한 최종 충전량
        for(int a = 0; a<bcCnt; a++){
            for(int b = 0; b<bcCnt; b++){
                int sum = 0; //현재 조합에서 최대값
                //현재 a의 위치에서 지정된 충전소가 되는지
                int totalA = check(a, playerA[0], playerA[1]);
                int totalB = check(b, playerB[0], playerB[1]);

                //두 충전소가 다르다면
                if(a != b) sum = totalA + totalB;
                // 같은 충전소를 사용하면 두개를 나눠쓰는거
                else sum = Math.max(totalA, totalB);

                max_val = Math.max(sum, max_val); //충전량 갱신
            }
        }
        return max_val;
    }
}
