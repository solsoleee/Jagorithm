package pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡볶이떡만들기 {
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int n,m,res;
    private static int arr[];
    public static void main(String[] args) throws IOException {
        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken());
        m = Integer.parseInt(tokens.nextToken());
        arr = new int [n];

        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        //이분탐색 해보자
        Arrays.sort(arr);
        int start = arr[0];
        int end = arr[n-1];

        while(start <=end ){
            //mid이걸로 떡 자르기
            int mid = (start + end) /2;
            int sum=0;
            for(int i=0; i<arr.length; i++){
                if(arr[i] - mid > 0) {
                    sum+= arr[i] - mid;
                }
            }
            //떡을 자른게 m에 최소 만족을 한다면 그니까 자른게 m보다 크다면 이미 만족
            if(sum >= m){
                res = mid; //저장하기
                //높이를 더 높여보자..
                start = mid+1;
            }
            else{ // sum<m이거인 경우니까 높이를 낮춰야 한다.
                end = mid-1;
            }
        }
        System.out.println(res);

    }

}
