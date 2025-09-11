package leetcode;

import java.util.List;
import java.util.Map;

public class ValidParentheses {
  public static void main(String[] args) {
    String s = "([])";
    System.out.println(solution(s));
  }

  public static boolean solution(String s) {

    if (s.length() <= 1 || s.length() % 2 == 1) {
      return false;
    }

    Map<Character, Integer> pesos = Map.of(
        '(', 1,
        '[', 2,
        '{', 3,
        ')', 1,
        ']', 2,
        '}', 3);

    List<Character> fechados = List.of(')', '}', ']');

    int atual = 0;
    int prox = atual + 1;
    int isValid = 0;

    while (atual < s.length() && prox < s.length()) {

      char simboloAtual = s.charAt(atual);
      char simboloProx = s.charAt(prox);

      int pesoAtual = pesos.get(simboloAtual);
      int pesoProx = pesos.get(simboloProx);

      if (fechados.contains(simboloAtual)) {
        if (fechados.contains(simboloProx) && isValid == 0) {
          return false;
        }
        atual++;
        prox = atual + 1;
        // isValid += pesoProx;
      } else if (pesoAtual == pesoProx) {
        atual++;
        prox = atual + 1;
        isValid -= pesoProx;
      } else {
        prox++;
        isValid += pesoProx;
      }

    }

    if (isValid <= 0) {
      return true;
    }
    return false;

  }
}