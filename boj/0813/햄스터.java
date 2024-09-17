import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class 햄스터 {



    private static StringTokenizer tokens;
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static int res[];
    private static int arr[];
    private static boolean visited[];
    private static int n, x, m, sum;
    private static int [] l,r,s;
    private static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int test = Integer.parseInt(input.readLine());


        tokens = new StringTokenizer(input.readLine());
        n = Integer.parseInt(tokens.nextToken()); //우리의 개수
        x = Integer.parseInt(tokens.nextToken()); //각 우리 최대 마리
        m = Integer.parseInt(tokens.nextToken()); //기록

        arr = new int[x+1];
        for(int i=0; i<=x; i++){
            arr[i] = i;
        }
        res = new int[n];
        visited = new boolean[x+1];
        l= new int [m];
        r= new int [m];
        s= new int [m];
        for(int i=0; i<m; i++){
            tokens = new StringTokenizer(input.readLine());
            l[i]= Integer.parseInt(tokens.nextToken());
            r[i]= Integer.parseInt(tokens.nextToken());
            s[i]= Integer.parseInt(tokens.nextToken());
            // l과 r을 합쳐서 l부터 r까지 arr[l]부터 arr[r]까지 더해서 s가 되야함

        }
        permutation(0);
//        for(int i=0; i<list.size(); i++){
//            int total=0;
//            for(int r:list.remove(i)){
//                total+=r;
//            }
//            if (sum < total){
//
//            }
//        }
        for(int i=0; i<list.size(); i++){
            System.out.println(Arrays.toString(list.get(i)));
        }

    }

    private static void permutation(int cnt) {
        if (cnt == n) {
            //조건에 맞는거 고름
            boolean flag = true;
            for (int i = 0; i < m; i++) {
//                System.out.print(l[i]);
//                System.out.print(r[i]);
//                System.out.print(s[i]);
                if (res[l[i] - 1] + res[r[i] - 1] != s[i]) {
                    flag = false;

                }
            }
            if (flag) {
                //System.out.println(Arrays.toString(res));
                //나온 res 중에서 햄스터가 가장 많은것, 사전순으로 앞선 것

                int total=0;
                for(int i=0; i<res.length; i++){
                    total += res[i];
                }
                if(sum< total){
                    list.add(res);
                    sum = total;
                }

//                int ans[] = new int[n]; //최종 정답 배열
//                int total=0;
//                for(int i=0; i<m; i++){
//                    total+= res[i];
//                    if(sum < total){
//                        ans = res;
//                    }

            }
            return;
        }
        for(int i=0; i<arr.length; i++){
//            if(!visited[i]){
            res[cnt] = arr[i];
//                visited[i] = true;
            permutation(cnt+1);
//                visited[i] = false;
//            }
        }

    }

    }

