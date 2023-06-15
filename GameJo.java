package ForkBaseballNumber;

import java.util.Arrays;
import java.util.Scanner;

public class GameJo {
    public static void main(String[] args) {
        // 1. 랜덤으로 0~9 사이 숫자 3개 생성하기  = 랜덤함수 생성
        // 1-1 랜덤으로 숫자 3개를 생성하고 저장할 곳 만들기
        //      단, 숫자가 겹치면 안됨.
        int[] randomNumbers = new int[3]; // 3개의 값이 저장될 곳 만들기

        for (int ballNum = 0; ballNum < randomNumbers.length; ballNum++) {
            randomNumbers[ballNum] = (int) (Math.random() * 10); // Math.random은 0이상 1미만의 값을 반환하기 때문에 10을 곱해서
                                                                // 0 ~ 10을 받아오게 만들어 줘야한다.

            for (int search = 0; search < ballNum; search++) {
                if (randomNumbers[ballNum] == randomNumbers[search]) {
                    ballNum--; // 중복된 숫자가 발견되면 ballNum을 다시 감소시킴
                    break; // 루프 탈출
                }
            }
        }
        System.out.println(Arrays.toString(randomNumbers)); // 중복없는 난수를 출력

        // 1-2 만들고 나서 "컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!" 출력하기
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        // 2. 숫자 3개 입력받기
        Scanner scanner = new Scanner(System.in);
        int[] pickNumbers = new int[3];
        System.out.println("세 자리 숫자를 입력하시오");
        // 2-1 숫자 3개를 입력받아 저장할 곳 만들기
        // 2-2 프린트로 몇번째 시도인지 출력하기
        int tryCount = 0;                                           // fix1 수정을 위해 try count = 0 으로 초기값을 수정

        while (true) {                                              // fix1 1번째 시도 000은 초기값인데, 0번째 시도로 나오게 표시하였고,
            if (tryCount > 0){                                      // 0번째 시도는 출력하지 않기위해 if (tryCount > 0) 이라는 조건을 추가함
                System.out.print(tryCount + "번째 시도 : ");         // fix2 "번째 시도 : " ) + ~~~ 뒷부분 Arrays.toString 삭제후
                for (int i = 0; i < pickNumbers.length; i++) {      // 반복문으로 picknumbers 배열 0 1 2 번째 출력
                    System.out.print(pickNumbers[i]);               // println 때문에 출력이 한  칸씩 내려와서 두 줄 모두 print로 작성
                }
                System.out.println();                               // 답을 입력하는  곳이 n번째 시도 : abc 바로옆에서 시작되어서 한 줄 밑에서 시작하게 추가함
            }
            for (int i = 0; i < pickNumbers.length; i++) {
                pickNumbers[i] = scanner.nextInt();
            }
            // 3. 숫자 3개를 비교해서 출력하기
            int strike = 0;
            int ball = 0;
            // 3-1 숫자를 하나씩 꺼내서 비교하여 출력하기.
            for (int i = 0; i < randomNumbers.length; i++) {
                for (int j = 0; j < pickNumbers.length; j++) {
                    if (randomNumbers[i] == pickNumbers[j]) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }
            // 3-2 숫자의 값과 위치가 모두 일치하면 일치한 횟수 + "S" +
            //     숫자의 값은 일치하지만 위치가 틀렸린 경우의 횟수 + "B" 출력하기
            System.out.println(ball + "B" + strike + "S");

            // 4. 3S가 출력이 된다면 몇번만에 맞췄는지 출력한 후에 게임 종료하기.
            if (strike == 3) {
                System.out.println(tryCount + "번만에 맞추셨습니다!");
                System.out.println("게임을 종료합니다.");
                break;
            }
            // 4-1 3S가 아니라면 다시 시도하게 만들기
            tryCount++;
            }
        }
    }



// 1. 랜덤으로 0~9 사이 숫자 3개 생성하기
// -> 랜덤함수 찾아서 쓰기
// 1-1 랜덤으로 숫자 3개를 생성하고 저장할 곳 만들기
// 랜덤함수 저장할 곳 int[] 랜덤함수 =

// 1-2 만들고 나서 "컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!" 출력하기
//      단, 숫자가 겹치면 안됨.

// 2. 숫자 3개 입력받기
// 2-1 숫자 3개를 입력받아 저장할 곳 만들기
// 2-2 프린트로 몇번째 시도인지 출력하기

// 3. 숫자 3개를 비교해서 출력하기
// 3-1 숫자를 하나씩 꺼내서 비교하여 출력하기.
// 3-2 숫자의 값과 위치가 모두 일치하면 일치한 횟수 + "S" +
//     숫자의 값은 일치하지만 위치가 틀렸린 경우의 횟수 + "B" 출력하기.

// 4. 3S가 출력이 된다면 몇번만에 맞췄는지 출력한 후에 게임 종료하기.
// 4-1 3S가 아니라면 다시 시도하게 만들기
