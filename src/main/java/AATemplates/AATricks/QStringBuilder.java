package AATemplates.AATricks;

public class QStringBuilder {
    class Q1119RemoveVowelsFromAString{
     public String removeVowels(String S) {
            StringBuilder sb = new StringBuilder();
            for (char c : S.toCharArray()) {
                if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
}
