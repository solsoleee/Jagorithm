package swea;

import java.io.*;
import java.util.*;

public class SWEA작업순서 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int v,e;
    private static List<List<Integer>> list;
    private static List<Integer> result;
    public static void main(String[] args) throws IOException {
        for (int t = 1; t <=10; t++) {
            //위상정렬 bfs로..
            //진입차수  0이 되면 (들어오는게 없다는 뜻이니까..)
            list = new ArrayList<>();
            result = new ArrayList<>();
            tokens = new StringTokenizer(input.readLine());
            v = Integer.parseInt(tokens.nextToken());
            e = Integer.parseInt(tokens.nextToken());
            for(int i=0; i<=v; i++){
                list.add(new ArrayList<>());
            }
            tokens = new StringTokenizer(input.readLine());
            for(int i=0; i<e; i++){
                int a = Integer.parseInt(tokens.nextToken());
                int b = Integer.parseInt(tokens.nextToken());
                list.get(a).add(b);
            }
            bfs();
            output.append("#").append(t).append(" ");
            for(int r: result){
                output.append(r).append(" ");
            }
            output.append('\n');
        }
        System.out.println(output);
    }
    //위상정렬
    private static void bfs(){
        int [] degree = new int[v+1]; //진입차수
        for(int i=1; i<=v; i++){
            for(int  j: list.get(i)){
                degree[j]++;
            }
        }
        Queue<Integer> que = new ArrayDeque<>();
        //진입 차수가 0인것만 넣기
        for(int d=1; d<degree.length; d++){
            if(degree[d] == 0){
                que.offer(d);
                result.add(d);
            }
        }
        while (!que.isEmpty()){
             int idx = que.poll();
             for(int i: list.get(idx)){
                 if(degree[i]!=0) {
                     degree[i]--;
                     if(degree[i] ==0){
                         que.offer(i);
                         result.add(i);
                     }
                 }
             }
        }
    }
}