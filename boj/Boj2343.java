package boj;
import java.io.*;
import java.util.*;

public class Boj2343 {
    static StringTokenizer tokens;
    static StringBuilder output = new StringBuilder();
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int n,m;
    static int []arr;
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        arr = new int[n];
        int res=0;
        tokens = new StringTokenizer(input.readLine());
        int end=0;
        int start=0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
            end += arr[i];
            start = Math.max(start, arr[i]);
        }

        while(start <= end) {
            int mid = (start + end) / 2;
            int sum=0;
            int cnt=0;
            for(int i=0; i<n; i++){
                if(sum + arr[i] > mid) {
                    cnt++;
                    sum=arr[i];
                }
                else if(sum + arr[i] == mid){
                    cnt++;
                    sum=0;
                }
                else{
                    sum += arr[i];
                }
            }
            if(sum > 0 && sum < mid) cnt++;

            //cnt가 m보다 작으면 범위가 너무 큰거
            if(cnt <= m){
                res = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        System.out.println(res);
    }
}