package su.levenetc.playground.java.algs;

public class IsPalindromeWithDeletedChar {

    static boolean is(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);

            if (leftCh == rightCh) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);
            if (leftCh != rightCh) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}
