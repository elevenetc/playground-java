package su.levenetc.playground.java.algs;

public class URLify {
    public static char[] urlfy(char... string) {
        replaceSpaces(string, getIndexOfLastNonSpaceChar(string));
        return string;
    }

    public static void replaceSpaces(char[] str, int lengthWithoutSpaces) {
        int spaceCount = 0, index, i;
        for (i = 0; i < lengthWithoutSpaces; i++) if (str[i] == ' ') spaceCount++;

        index = lengthWithoutSpaces + spaceCount * 2;
        if (lengthWithoutSpaces < str.length) str[lengthWithoutSpaces] = '\0';

        for (i = lengthWithoutSpaces - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static int getIndexOfLastNonSpaceChar(char[] str) {
        for (int i = str.length - 1; i >= 0; i--)
            if (str[i] != ' ')
                return i + 1;
        return -1;
    }
}
