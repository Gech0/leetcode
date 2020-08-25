import java.util.ArrayList;

public class T859_buddyStrings {
    /*
    相同但是可以交换；相同，但是不能交换
    1、A="aa",B="aa"，==》 true
    2、A="ab",B="ab" ==》 false
     */
    public static void main(String[] args) {
        String A = "ab";
        String B = "ab";

    }
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        int i = 0;
        ArrayList<Integer> diff = new ArrayList<>();
        while (i < A.length()) {
            if (A.charAt(i) != B.charAt(i)) {
                diff.add(i);
            }
            if (diff.size() > 2) return false;
            i++;
        }
        return A.charAt(diff.get(0)) == B.charAt(diff.get(1))
                && A.charAt(diff.get(1)) == B.charAt(diff.get(0));
    }
}
