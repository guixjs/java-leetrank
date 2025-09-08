package leetcode;

import java.util.Map;

public class RomanToInteger {
  public static void main(String[] args) {
    String valorEmRomano = "MCMXCIV";
    romanToInteger(valorEmRomano);
  }

  public static int romanToInteger(String s) {

    Map<String, Integer> lista = Map.of(
        "M", 1000,
        "D", 500,
        "C", 100,
        "L", 50,
        "X", 10,
        "V", 5,
        "I", 1);
    int numero = 0;
    int proxNumero = 0;
    int valorConvertido = 0;

    for (int i = 0; i < s.length(); i++) {
      numero = lista.get(String.valueOf(s.charAt(i)));
      if (i < s.length() - 1) {
        proxNumero = lista.get(String.valueOf(s.charAt(i + 1)));
      }

      if (numero < proxNumero) {
        numero *= -1;
      }

      valorConvertido += numero;
    }

    System.out.println("VALOR CONVERTIDO: " + valorConvertido);
    return 0;
  }
}
