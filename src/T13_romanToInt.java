import java.util.HashMap;

public class T13_romanToInt {

    public static void main(String[] args) {
//        System.out.println(new T13_romanToInt().romanToInt("XII"));
        System.out.println(new T13_romanToInt().romanToInt("MCMXCIV"));
        System.out.println(new T13_romanToInt().romanToInt_IV("MCMXCIV"));

    }

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            char chNext = s.charAt(i + 1);
            switch (ch){
                case 'M' :
                    result += 1000;
                    break;
                case 'D' :
                    if (chNext == 'M'){
                        result -= 500;
                        break;
                    }
                    result += 500;
                    break;
                case 'C' :
                    if (chNext=='D'||chNext=='M'){
                        result -= 100;
                        break;
                    }
                    result += 100;
                    break;
                case 'L' :
                    if (chNext == 'C' ||
                            chNext=='D'||chNext=='M'){
                        result -= 50;
                        break;
                    }
                    result += 50;
                    break;
                case 'X' :
                    if (chNext == 'C' ||chNext =='L'||
                            chNext=='D'||chNext=='M'){
                        result -= 10;
                        break;
                    }
                    result += 10;
                    break;
                case 'V' :
                    if (chNext == 'C' ||chNext =='L'||chNext=='X'||
                            chNext=='D'||chNext=='M'){
                    result -= 5;
                    break;
                }
                    result += 5;
                    break;
                case 'I' :
                    if (chNext == 'C' ||chNext =='L'||chNext=='X'||
                            chNext=='V'||chNext=='D'||chNext=='M'){
                        result -= 1;
                        break;
                    }
                    result += 1;
            }
        }
        switch (s.charAt(s.length()-1)){
            case 'M' :
                result += 1000;
                break;
            case 'D' :
                result += 500;
                break;
            case 'C' :
                result += 100;
                break;
            case 'L' :
                result += 50;
                break;
            case 'X' :
                result += 10;
                break;
            case 'V' :
                result += 5;
                break;
            case 'I' :
                result += 1;
        }
        return result;
    }

    public int romanToInt_II(String s) {
        int result = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length()-1 && map.containsKey(s.substring(i, i + 2))){
                result += map.get(s.substring(i, i + 2));
                i ++;
            } else {
                result += map.get(s.charAt(i)+"");
            }
        }
        return result;
    }

    public int romanToInt_III(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1
                    && map.get(s.charAt(i)) < map.get(s.charAt(i + 1)) ) {
                result -= map.get(s.charAt(i));
            }else {
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }

    public int romanToInt_IV(String s) {
        int res = 0;
        int pre = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int cur = getValue(s.charAt(i));
            res = pre < cur ? res - pre : res + pre;
            pre = cur;
        }
        res += pre;
        return res;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
