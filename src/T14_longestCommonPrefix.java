public class T14_longestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new T14_longestCommonPrefix()
                .longestCommonPrefix(new String[]{"aa", "a"}));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            prefix.append(strs[0].charAt(i));
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length() - 1 ){
                    return prefix.substring(0, i);
                }
                if (!strs[j].substring(0, i + 1).contentEquals(prefix)){
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix.toString();
    }
}
