package com.example.calculator;
import java.util.*;

public class Calculator {
    // [1] 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    private ArrayList<Integer> results = new ArrayList<>();


    // [2] 사칙연산을 수행한 후, 결과값을 반환하는 메서드 구현
    public int Calculate(int num1, int num2, char operator) {
        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new IllegalArgumentException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                System.out.println("오류 : 유효하지 않은 연산 기호입니다.");
        }


        // [3] 연산 수행 후, 결과값을 컬렉션 타입 필드에 저장
        this.results.add(result);

        // [4] 연산 결과 반환
        return result;
    }

    // [5] 게터 활용
    public ArrayList<Integer> getResults() {
        return this.results;
    }


    // [6] 세터 활용
    public void setResults(int index, int newValue) {
        this.results.set(index, newValue);
    }

    // [7] 가정 먼저 저장된 데이터 삭제하기
    public void removeResult() {
        this.results.remove(0);
        System.out.println("가장 오래된 연산 결과가 삭제되었습니다.");
    }
}


