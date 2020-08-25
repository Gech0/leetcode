public class T557_reverseWords {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            sb.append(new StringBuilder(words[i]).reverse()+" ");
        }
        sb.append(new StringBuilder(words[words.length - 1]).reverse());
        return sb.toString();
    }
}
