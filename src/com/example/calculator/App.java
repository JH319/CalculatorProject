package com.example.calculator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // [6] Calculator 인스턴스 생성
        Calculator cal = new Calculator();

        Scanner sc = new Scanner(System.in);

        // [4] "exit"하기 전까지 반복하기
        while(true) {

            // [1] 양의 정수(0 포함)를 입력받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();


            // [2] 사칙연산 기호를 입력받기
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /) : ");
            char operator = sc.next().charAt(0);


            // [3] 연산 후 결과값 출력하기 ---> // [7] Calculator 클래스로 연산하기
            int result = cal.Calculate(num1, num2, operator);

            // [8] 결과 반환하기
            if (result !=0) {
                System.out.println("결과: " + result);
            }

//            int result = 0;
//            boolean calculated = true;
//
//            switch (operator) {
//                case '+':
//                    result = num1 + num2;
//                    break;
//                case '-':
//                    result = num1 - num2;
//                    break;
//                case '*':
//                    result = num1 * num2;
//                    break;
//                case '/':
//                    if (num2 == 0) {
//                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
//                        calculated = false;
//                    } else {
//                        result = num1 / num2;
//                    }
//                    break;
//                default:
//                    System.out.println("오류 : 유효하지 않은 연산 기호입니다.");
//                    calculated = false;
//                    break;
//            }
//
//            if (calculated) {
//                System.out.println("결과: " + result);
//            }

            // [5] 계산 후, 종료 여부 묻기
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = sc.next();

            if ("exit".equals(answer)) {
                System.out.println("계산을 종료합니다.");
                break;
            }
        }
    }
}

