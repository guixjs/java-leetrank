package leetcode;

import java.util.List;
import java.util.Map;

public class ValidParentheses {
  public static void main(String[] args) {
    String s = "{()}";
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

    List<Character> abertos = List.of('(', '{', '[');

    int atual = 0;
    int prox = atual + 1;

    while (prox < s.length()) {

      char simboloAtual = s.charAt(atual);
      char simboloProx = s.charAt(prox);

      int pesoAtual = pesos.get(simboloAtual);
      int pesoProx = pesos.get(simboloProx);

      if (pesoAtual == pesoProx) {
        atual++;
        prox = atual + 1;
      } else {
        prox++;
      }
      if (!abertos.contains(simboloAtual)) {
        return false;
      }
    }

    return true;
  }
}
