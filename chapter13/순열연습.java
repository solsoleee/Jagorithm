package chapter13;

import java.util.Arrays;

public class 순열연습 {
    private static int res[];
    private static boolean visited[];
    private static int arr[];

    private static int r;

    public static void main(String args[]){
        r= 5;
        res = new int [r];
        arr = new int [10];
        visited = new boolean[10];

        for(int i=0; i<10; i++){
            arr[i] = i;
        }
        permutation(0);
    }

    private static void permutation(int cnt){
        if(cnt >= r) {
            System.out.println(Arrays.toString(res));
            return;
        }

        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                res[cnt] = arr[i];
                visited[i] = true;
                permutation(cnt+1);
                visited[i] = false;
            }
        }


    }


}
