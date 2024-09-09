package boj;

import java.io.*;
import java.util.*;

public class Boj1715 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        arr = new int [n];
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(input.readLine());
            que.offer(arr[i]);
        }
        int sum = 0;
        while(que.size() > 1){
            int add = que.poll() + que.poll();
            que.offer(add);
            sum += add;
        }

        System.out.println(sum);
    }

}
