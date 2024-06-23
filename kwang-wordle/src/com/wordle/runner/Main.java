package com.wordle.runner;
/*
todo
특수기호가 들어가있으면 다시 입력하라고 하기
 */

import com.wordle.user_defined_exceptions.InvalidLengthException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    //변수 초기화
    char answer0, answer1, answer2, answer3, result0, result1, result2, result3;  // 정답과 답변을 담을 변수
    String resultString = "java";  // 임시 답변
    int s, b;  // strike와 ball카운트

    // 사용자 입력 받기
    Scanner sc = new Scanner(System.in);
    System.out.println("wordle 게임을 시작합니다.");

    // 정답 맞히기
    for (int i = 5; i >= -1; i--) {

      // 기회를 모두 소모하면 킹받는 문구 출력
      if (i == -1) {
        System.out.println("그걸 몰라?");
        break;
      }

      // 기회가 있을 경우 정답맞히기
      try {
        s = b = 0;
        System.out.print("단어를 입력해주세요: ");
        String answerString = sc.nextLine();
        System.out.println("입력받은 문자열 : " + answerString);

        if (answerString.length() != 4) {

          throw new InvalidLengthException("4글자 단어를 입력해주세요");

        } else if (answerString.equals(resultString)) {

          System.out.println("정답을 맞히셨습니다!");
          break;

        } else {

          answer0 = answerString.charAt(0);
          answer1 = answerString.charAt(1);
          answer2 = answerString.charAt(2);
          answer3 = answerString.charAt(3);

          result0 = resultString.charAt(0);
          result1 = resultString.charAt(1);
          result2 = resultString.charAt(2);
          result3 = resultString.charAt(3);

          if (answer0 == result0) {
            s++;
          } else if (answer0 == result1 || answer0 == result2 || answer0 == result3) {
            b++;
          }

          if (answer1 == result1) {
            s++;
          } else if (answer1 == result0 || answer1 == result2 || answer1 == result3) {
            b++;
          }

          if (answer2 == result2) {
            s++;
          } else if (answer2 == result0 || answer2 == result1 || answer2 == result3) {
            b++;
          }

          if (answer3 == result3) {
            s++;
          } else if (answer3 == result0 || answer3 == result1 || answer3 == result2) {
            b++;
          }

          if (s == 0 && b == 0) {
            System.out.println("nothing");
          }
          System.out.println("[" + s + "S" + b + "B" + "]");
          System.out.println("기회는 " + i + "번 남았습니다.");
        }
        // 글자수가 4글자가 아닐 경우
      } catch (InvalidLengthException e) {
        i++;
        System.out.println(e.getMessage());
      } finally {
        continue;
      }
    }
  }
}
