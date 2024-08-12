package chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14888 {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokens;
    private static int min_value=Integer.MAX_VALUE,
                        max_value=Integer.MIN_VALUE;
    private static int arr[];
    private static int plus,minus,multiply,divide;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(input.readLine());

        tokens = new StringTokenizer(input.readLine());

        arr = new int [n];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        tokens = new StringTokenizer(input.readLine());
        plus = Integer.parseInt(tokens.nextToken());
        minus = Integer.parseInt(tokens.nextToken());
        multiply = Integer.parseInt(tokens.nextToken());
        divide = Integer.parseInt(tokens.nextToken());

        dfs(arr[0], 1);
        System.out.println(max_value);
        System.out.println(min_value);

        }

        private static void dfs(int res, int idx){

            //모든 숫자를 사용했으면 결과 갱신
            if(idx == arr.length){
                max_value  = Math.max(max_value, res);
                min_value = Math.min(min_value, res);
                return;
            }

            // 가능한 모든 연산 시도
            if(plus>0){
                plus--;
                dfs(res+arr[idx], idx+1);
                plus++;
            } if (minus>0) {
                minus--;
                dfs(res-arr[idx], idx+1);
                minus++;
            }
            if (multiply>0) {
                multiply--;
                dfs(res*arr[idx], idx+1);
                multiply++;
            }
            if(divide>0){
                divide--;
                dfs(res/arr[idx], idx+1);
                divide++;
            }

        }

    }
