package su.levenetc.playground.java.algs;

public class IsNumberPalindrome {
    public boolean IsPalindrome(int n) {
        //if numbers ends with zero then it's not palindrome
        if (n < 0 || (n % 10 == 0 && n != 0)) return false;

        int inverted = 0;
        while (n > inverted) {
            inverted = inverted * 10 + n % 10;
            n /= 10;
        }

        //division by 10 is for case odd amount of numbers: "12521" > "12 != 125" > "125/10=12" > "12 == 12"
        return n == inverted || n == inverted / 10;
    }
}
