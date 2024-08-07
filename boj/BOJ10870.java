package boj;

import java.io.IOException;
import java.util.Scanner;

public class BOJ10870 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }


    private static int factorial(int n){
        if (n<=0){
            return 0;
        } else if (n==1) {
            return 1;
        }
        else{
            return factorial(n-1)+factorial(n-2);
        }
    }
}
