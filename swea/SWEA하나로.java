package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA하나로 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static double e;

    private static long dist[][]; // 두 섬 간의 거리 정보를 저장할 배열
    private static boolean visited[];
    private static long[] minDist; //각 노드까지의 최소 거리를 저장할 배열
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++){
            n = Integer.parseInt(input.readLine());
            int [] x = new int[n];
            int [] y = new int [n];

            tokens = new StringTokenizer(input.readLine());
            for (int i = 0; i < n; i++) {
                x[i] = Integer.parseInt(tokens.nextToken());
            }

            tokens = new StringTokenizer(input.readLine());
            for (int i = 0; i < n; i++) {
                y[i] = Integer.parseInt(tokens.nextToken());
            }

            e = Double.parseDouble(input.readLine());
            visited = new boolean[n];
            minDist = new long[n];
            dist = new long[n][n];

            //초기화
            for(int i=0; i< n; i++) {
                minDist[i] = Long.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if(i!=j) {
                        dist[i][j] = (long) (Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
                    }
                }
            }


            //prim 알고리즘
            long cost = 0;
            minDist[0] = 0; //시작점 설정

            for(int i=0; i<n; i++){
                long min = Long.MAX_VALUE;
                int minVertex = -1;

                //방문하지 않은 노드 중에서 최소 거리 노드를 선택
                for(int j=0; j<n; j++) {
                    if(!visited[j] && minDist[j] < min){
                        min = minDist[j];
                        minVertex = j;
                    }
                }
                if(minVertex==-1) break; //더이상 연결할 노드가 없음
                visited[minVertex] = true; //선택된 노드 방문처리
                cost += min;

                for(int j=0; j<n; j++){ //선택된 노드와 다른 노드들의 최소 거리를 업데이트
                    if(!visited[j] && dist[minVertex][j] < minDist[j]){
                        minDist[j] = dist[minVertex][j];
                    }
                }
            }
            cost = Math.round(cost * e);
            System.out.println(cost);
        }
    }

}
