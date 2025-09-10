package leetcode;

public class CommonPrefix {
  public static void main(String[] args) {
    String[] strs = { "abab", "aba", "" };
    System.out.println(solution(strs));
  }

  public static String solution(String[] strs) {

    if (strs.length == 1) {
      return strs[0];
    }

    String prefix = strs[0];
    String nextWord;
    int i;
    int letra = 0;
    boolean isPrefix;

    for (i = 1; i < strs.length; i++) {
      nextWord = strs[i];
      letra = 0;
      isPrefix = true;
      while (isPrefix && letra < prefix.length()) {

        if (nextWord.length() < 1) {
          return "";
        }

        if (prefix.charAt(letra) == nextWord.charAt(letra)) {
          letra++;
        } else {
          isPrefix = false;
          prefix = nextWord.substring(0, letra);
          break;
        }
        if (letra >= prefix.length() || letra >= nextWord.length()) {
          prefix = nextWord.substring(0, letra);
          break;
        }

      }
    }
    return prefix;

  }
}
