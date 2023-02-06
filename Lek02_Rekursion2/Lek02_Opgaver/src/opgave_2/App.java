package opgave_2;

public class App {
    public static void main(String[] args) {
        String text1 = "kajak";
        String text2 = "albatros";
        String text3 = "abcdeedcba";
        System.out.println("Text 1 : " + palindrom2(text1));
        System.out.println("Text 2 : " + palindrom2(text2));
        System.out.println("Text 3 : " + palindrom2(text3));

    }

    // #-- MED SUBSTRINGS --#
    public static boolean palindrom1(String text) {
        if (text.length() <= 1) {
            return true;
        } else {
            if (text.charAt(0) == text.charAt(text.length() - 1)) {
                return palindrom1(text.substring(1, text.length() - 1));
            } else {
                return false;
            }
        }
    }

    // #-- UDEN SUBSTRINGS --#
    public static boolean palindrom2(String text) {
        return palindrom2(text, 0);
    }

    private static boolean palindrom2(String text, int n) {
        int length = text.length();
        if (n == length / 2) {
            return true;
        } else {
            if (text.charAt(n) == text.charAt(length - 1 - n)) {
                return palindrom2(text, n + 1);
            } else {
                return false;
            }
        }
    }

}
