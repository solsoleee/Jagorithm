package chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18352 {

    private static int n,m,k,x;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer output = new StringBuffer();
    private static StringTokenizer tokens;
    private static ArrayList<Integer> map[];
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        k = Integer.parseInt(tokens.nextToken());
        x = Integer.parseInt(tokens.nextToken());

        map = new ArrayList [n+1];
        visited = new boolean[n+1];

        for(int i=0; i<n+1; i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            tokens = new StringTokenizer(input.readLine());
            int num1 = Integer.parseInt(tokens.nextToken());
            int num2 = Integer.parseInt(tokens.nextToken());

            map[num1].add(num2);
        }
        Queue <int[]> que = new LinkedList<>();
        List <Integer> res = new LinkedList<>(); //정답
        que.add(new int[] {x, 0});
        visited[x] = true;
        while(!que.isEmpty()) {
            int t[] = que.poll();
            int dx=t[0];
            int count = t[1];
            if (count == k) {
                res.add(dx);
            }
            for(int i: map[dx]){
                if(!visited[i]){
                    que.offer(new int []{i, count+1});
                    visited[i]=true;
                }
            }


//            for (int i = 0; i < map[dx].size(); i++) {
//                int temp = map[dx].get(i);
//                if (!visited[temp]) {
//                    visited[temp] = true;
//                    que.offer(new int[]{temp, count + 1});
//                }
//            }
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(temp[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println("**");

        }
        Collections.sort(res);
        if(res.isEmpty()){
            System.out.println(-1);
        }
        else{
            for(int r : res){
                System.out.println(r);
            }
        }

    }
}
