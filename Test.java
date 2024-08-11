import java.net.*;
import java.io.*;

public class Test {

    // 닉네임을 사용자에 맞게 변경해 주세요.
    static final String NICKNAME = "DAEJEON02_JAVA";

    // 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
    static final String HOST = "127.0.0.1";

    // 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
    static final int PORT = 1447;
    static final int CODE_SEND = 9901;
    static final int CODE_REQUEST = 9902;
    static final int SIGNAL_ORDER = 9908;
    static final int SIGNAL_CLOSE = 9909;

    // 게임 환경에 대한 상수입니다.
    static final int TABLE_WIDTH = 254;
    static final int TABLE_HEIGHT = 127;
    static final int NUMBER_OF_BALLS = 6;
    static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

    public static void main(String[] args) {

        Socket socket = null;
        String recv_data = null;
        byte[] bytes = new byte[1024];
        float[][] balls = new float[NUMBER_OF_BALLS][2];
        int order = 0;

        try {
            socket = new Socket();
            System.out.println("Trying Connect: " + HOST + ":" + PORT);
            socket.connect(new InetSocketAddress(HOST, PORT));
            System.out.println("Connected: " + HOST + ":" + PORT);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            String send_data = CODE_SEND + "/" + NICKNAME + "/";
            bytes = send_data.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("Ready to play!\n--------------------");

            while (socket != null) {

                // Receive Data
                bytes = new byte[1024];
                int count_byte = is.read(bytes);
                recv_data = new String(bytes, 0, count_byte, "UTF-8");
                System.out.println("Data Received: " + recv_data);

                // Read Game Data
                String[] split_data = recv_data.split("/");
                int idx = 0;
                try {
                    for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                        for (int j = 0; j < 2; j++) {
                            balls[i][j] = Float.parseFloat(split_data[idx++]);
                        }
                    }
                } catch (Exception e) {
                    bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
                    os.write(bytes);
                    os.flush();
                    System.out.println("Received Data has been corrupted, Resend Requested.");
                    continue;
                }

                // Check Signal for Player Order or Close Connection
                if (balls[0][0] == SIGNAL_ORDER) {
                    order = (int) balls[0][1];
                    System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
                    continue;
                } else if (balls[0][0] == SIGNAL_CLOSE) {
                    break;
                }

                // Show Balls' Position
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                    System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
                }

                float angle = 0.0f;
                float power = 0.0f;


                ////여기부터 코드 시작

                // 흰 공의 위치
                float whiteBall_x = balls[0][0];
                float whiteBall_y = balls[0][1];

                // 목표 공의 위치 초기화
                float targetBall_x = -1;
                float targetBall_y = -1;

                // 쳐야 할 공을 선택 (스테이지별로 로직 조정 가능)
                // order는 플레이어의 순서를 나타내는 변수로 선공일 경우 1, 후공일 경우 2의 값을 가진다.
                int[] targetBalls = order == 1 ? new int[]{1, 3, 8} : new int[]{2, 4, 8};

                for (int ballIndex : targetBalls) {
                    if (balls[ballIndex][0] != -1 && balls[ballIndex][1] != -1) {
                        targetBall_x = balls[ballIndex][0];
                        targetBall_y = balls[ballIndex][1];
                        break;
                    }
                }

                // 포켓 위치 중 가장 가까운 포켓 선택
                float hole_x = HOLES[0][0];
                float hole_y = HOLES[0][1];
                double minDistance = distance(hole_x, hole_y, targetBall_x, targetBall_y);
                for (int[] hole : HOLES) {
                    double d = distance(hole[0], hole[1], targetBall_x, targetBall_y);
                    if (d < minDistance) { // 더 가까운 포켓이 발견되면
                        minDistance = d; // 최소 거리 갱신
                        hole_x = hole[0]; // 그 포켓을 목표 포켓으로 설정
                        hole_y = hole[1];
                    }
                }

                // 가(θ) 각도 계산
                double ga = Math.atan2(hole_y - targetBall_y, hole_x - targetBall_x);

                // 다(θ) 각도 계산 - 제2코사인 법칙
                double a = distance(whiteBall_x, whiteBall_y, hole_x, hole_y);
                double b = distance(targetBall_x, targetBall_y, hole_x, hole_y);
                double c = distance(whiteBall_x, whiteBall_y, targetBall_x, targetBall_y);
                double da = Math.acos((a * a + c * c - b * b) / (2 * a * c));

                // 최종 각도
                angle = (float) Math.toDegrees(ga + da);
                if (angle < 0) {
                    angle += 360; // 각도 값을 0~360도로 변환
                }

                // 두 점(좌표) 사이의 거리 계산
                double distance = Math.sqrt(Math.pow(targetBall_x - whiteBall_x, 2) + Math.pow(targetBall_y - whiteBall_y, 2));

                // 힘 계산 (거리 기반으로 조정)
                power = (float) Math.min(100, distance * 0.8); // 거리에 따라 힘을 조정, 최대값은 100


//                --------최종--------



                // 데이터 전송
                String merged_data = angle + "/" + power + "/";
                bytes = merged_data.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("Data Sent: " + merged_data);
            }

            os.close();
            is.close();
            socket.close();
            System.out.println("Connection Closed.\n--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 두 점 사이의 거리를 계산하는 함수
    public static double distance(float x1, float y1, float x2, float y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
