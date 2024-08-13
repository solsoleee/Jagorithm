//package s;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
///**
// @author 한소리
// @since 2024. 8. 13.
// @link https://www.acmicpc.net/submit/18429/82420196
// @timecomplex (n!)
// @performance 14904kb 144ms
// @category #permutation
// @note */
//
//public class SWEA_Ladder1 {
//    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//    private static StringTokenizer tokens;
//    private static StringBuilder output = new StringBuilder();
//    private static int map[][] = new int [100][100];
//
//    public static void main(String[] args) throws IOException {
//        int test = Integer.parseInt(input.readLine());
//        for(int i=0; i<100; i++){
//            tokens = new StringTokenizer(input.readLine());
//            for(int j=0; j<100; j++){
//                map[i][j] = Integer.parseInt(tokens.nextToken());
//            }
//        }
//
//        int d = 0;
//        //목적지 찾기
//        for(int i=0; i<100; i++){
//            if(map[i][99] ==2) {
//                d=i;
//            }
//        }
//        //출발지 찾기
//        int start[] = new int[100];
//        int size=0;
//        for(int i=0; i<100; i++){
//            if(map[i][0]==1){
//                start[size++]=i;
//            }
//        }
//        start = Arrays.copyOfRange(start, 0, size);
//        int deltas[][] ={{1,0}, {0,1}};
//        int direction = 0;
//        while(true){
//            for(int s: start){ //s가 출발지
//                for(int i=0; i<100; i++){
//                    if(s+1 < 100 && map[i][s+1]==1){
//                        direction = (direction+1) % 2;//방향 전환
//                    }
//                    if()
//                    if (map[i][s]; //아래로 내려가기
//                }
//            }
//
//        }
//
//
//        //System.out.println(Arrays.deepToString(map));
//         //x의 값은 2인 값 map[99][x]==2?
////        for(int i=0; i<100; i++){
////            if(map[i][0]==1){ //첫째줄이 1인 사다리만 고른다.
////                //이것이 목표에 도달하는지 바닥이 2일 때를 만나는지 확인하면 됨
////                for(int j=0; j<100; j++){
////                    //아래로 +1만큼 내려가기
////                    if(i+1 < 100){
////                        if(map[j][i+1]==1){ //옆에 통로가 있다면 옆에 통로로 넘어가기
////
//// }
////                    }
////
////                }
////            }
////
////        }
//
//
//    }
//
//}
