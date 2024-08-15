import java.util.Arrays;

public class 순열{

    private static boolean visited[]; //방문기록
    private static int res[]; //후보 배열
    private static int arr[]; //선택할거 배열
    private static int r; //선택할 수


    public static void main(String args[]) {
        r=5;
        arr = new int [10];
        res = new int [r];
        visited = new boolean[10];

        for(int i=0; i<10; i++) {
            arr[i] = i;
        }
        permutation(0);
    }



    private static void permutation(int depth){
        if(depth >= r){
            System.out.println(Arrays.toString(res));
            return;
        }

        for(int i=0; i<arr.length; i++) {
            if(!visited[i]){
                res[depth] = arr[i];
                visited[i] =true;
                permutation(depth+1);
                visited[i] = false;
            }
        }

    }
}