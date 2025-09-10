package leetcode;

public class CommonPrefix {
  public static void main(String[] args) {
    String[] strs = { "ab", "ab" };
    System.out.println(solution(strs));
  }

  public static String solution(String[] strs) {

    if (strs.length == 1) {
      return strs[0];
    }

    String prefix = "";
    String firstWord = strs[0];
    String nextWord;
    int i;
    int letra = 0;
    boolean isPrefix;
    String prefixTemp = strs[0];

    for (i = 1; i < strs.length; i++) {
      nextWord = strs[i];
      letra = 0;
      isPrefix = true;

      while (isPrefix && letra < prefix.length()) {

        if (letra >= firstWord.length() || letra > nextWord.length()) {
          return prefix;
        }
        if (prefixTemp.charAt(letra) == nextWord.charAt(letra)) {
          letra++;
          prefixTemp = nextWord.substring(0, letra);
        } else {
          isPrefix = false;
          break;
        }
        prefix = prefixTemp;

      }
    }
    return prefix;

  }
}
