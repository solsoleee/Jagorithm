package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA8275햄스터 {
    private static int T,n,x,m;
    private static int[] l_arr,r_arr,s_arr;
    private static int[] candidate; //n개의 후보
    private static int[] ham; //우리 안에 든 햄스터
    private static int[] res;
    private static StringTokenizer tokens;
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(input.readLine());
        for(int t=1; t<=T; t++){
            tokens = new StringTokenizer(input.readLine());
            n = Integer.parseInt(tokens.nextToken());
            x = Integer.parseInt(tokens.nextToken());
            m = Integer.parseInt(tokens.nextToken());

            candidate = new int [n];
            res = null;
            ham = new int[x+1];
            l_arr = new int[m];
            r_arr = new int[m];
            s_arr = new int[m];
            for(int i=0; i<m; i++){
                tokens = new StringTokenizer(input.readLine());
                l_arr[i] = Integer.parseInt(tokens.nextToken());
                r_arr[i] = Integer.parseInt(tokens.nextToken());
                s_arr[i] = Integer.parseInt(tokens.nextToken());
            }
            //0부터 X까지 햄스터 우리에 들어갈 수 있는 최대 수
            for(int i=0; i<=x; i++){
                ham[i] = i;
            }
            permutatoin(0);
            output.append("#").append(t);
            if (res == null) {  // 기록을 만족하는 배치가 없는 경우
                output.append(" -1\n");
            } else {
                for (int r : res) {
                    output.append(" ").append(r);
                }
                output.append("\n");
            }
        }
        System.out.print(output);
    }
    private static void permutatoin(int cnt){ //n개의 배열를 만듬
        boolean flag = true;
        int sum = -1;
        if(cnt == n){
            //candiate 배열 나온 거 중에서 m 리스트를 만족하는 것만 선별
            for(int i=0; i<m; i++){
                int s=0;
                for(int j=l_arr[i]-1; j<r_arr[i]; j++){
                    s+=candidate[j];
                }
                if(s != s_arr[i]) {
                    flag = false;
                }
            }
            if(flag){ //m의 리스트를 다 만족하는 것 중에서
                // 배열의 합을 구함
                sum = arrSum(candidate); //현재수 합의 수
                //넣어있는 것보다 후보가 더 크다면,
                //같은거는 생각 안해줌, 어차피 오름 차순으로 넣기 때문에 신경X
                if(arrSum(res) < sum){
                    res = candidate.clone(); // 넣기
                }
            }
            //System.out.println(Arrays.toString(res));
            return;
        }
        //햄스터 마리 중에서 후보 배열을 만듬
        for(int i=0; i<ham.length; i++){
            candidate[cnt] = ham[i];
            permutatoin(cnt+1);
        }
    }
    //배열의 합을 구하는 함수
    private static int arrSum(int can[]){
        int sum=0;
        if(can == null){
            return -1;
        }
        else{
            for(int i=0; i<can.length; i++){
                sum += can[i];
            }
            return sum;
        }
    }
}
