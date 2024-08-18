package boj;

import java.io.*;
import java.util.*;
public class Boj두용액 {
    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder output = new StringBuilder();
    private static int n;
    private static int[] arr, res;
    private static int min_value = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(input.readLine());
        arr = new int [n];

        tokens =  new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        res = new int[2];
        Arrays.sort(arr);
        int left = 0;
        int right = n-1;
        while(left < right){
            int sum = arr[left] + arr[right];
            int resSum = Math.abs(sum);

            if(resSum < min_value){
                min_value = resSum;
                res[0] = arr[left];
                res[1] = arr[right];
            }
            if(sum<0) left++; //합이 0보다 작으면 왼쪽 포인터를 오른쪽으로
            else right--; //합이 0보다 크면 오른쪽 포린터를 왼쪽으로
        }

        for(int a: res){
            output.append(a).append(" ");
        }
        System.out.print(output);
    }

}
