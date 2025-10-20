package com.example.calculator;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Calculator 인스턴스 생성
        Calculator cal = new Calculator();

        Scanner sc = new Scanner(System.in);

        // [7] "exit"하기 전까지 반복하기
        while(true) {
            try {
                // [1] 양의 정수(0 포함)를 입력받기
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();


                // [2] 사칙연산 기호를 입력받기
                System.out.print("사칙연산 기호를 입력하세요(+, -, *, /) : ");
                char operator = sc.next().charAt(0);


                // [3] Calculator 클래스로 연산하기
                int result = cal.Calculate(num1, num2, operator);


                // [4] 결과 반환하기
                if (result != 0) {
                    System.out.println("결과: " + result);
                }


                // [5] 결과 리스트 반환하기
                // 게터 활용
                ArrayList<Integer> arrResults = cal.getResults();
                System.out.println("::: 결과 리스트 = " + arrResults);


                // [6] 계산 후, 종료 여부 묻기
                System.out.println("더 계산하시겠습니까? (exit : 입력 시 종료 / modify : 입력 시 수정 / delete : 입력 시 첫번째 값 삭제" +
                        ")");
                String answer = sc.next();


                // [8] 세터를 활용한 수정 기능
                if ("exit".equals(answer)) {
                    System.out.println("계산을 종료합니다.");
                    break;
                } else if ("modify".equals(answer)) {
                    // 세터 활용
                    System.out.print("::: 수정할 인덱스를 입력하세요 : ");
                    int index = sc.nextInt();
                    System.out.print("::: 수정할 값을 입력하세요 : ");
                    int newValue = sc.nextInt();

                    // 수정 기능 호출
                    cal.setResults(index, newValue);
                    ArrayList<Integer> modifyResult = cal.getResults();
                    System.out.println("::: 수정 된 결과 리스트 = " + modifyResult);

                    // 수정 후 사용자에게 다음 행동을 다시 묻기
                    System.out.println("더 계산하시겠습니까? (exit : 입력 시 종료)");
                    String afterModify = sc.next();
                    if ("exit".equals(afterModify)) {
                        break;
                    }
                } // [9] 첫번째 인덱스 삭제 기능
                else if ("delete".equals(answer)) {
                    cal.removeResult();

                    // 삭제 후 결과 리스트 확인
                    ArrayList<Integer> modifyResult = cal.getResults();
                    System.out.println("::: 삭제 된 결과 리스트 = " + modifyResult);

                // 삭제 후 사용자에게 다음 행동을 다시 묻기
                    System.out.println("더 계산하시겠습니까? (exit : 입력 시 종료)");
                    String afterModify = sc.next();
                    if ("exit".equals(afterModify))
                        break;

                }

            } catch (IllegalArgumentException e) {
                System.out.println("🚨 Error : " + e.getMessage());
            }
        }
    }
}

