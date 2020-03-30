package base.huawei;

public class longestPalindrome {
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindrome(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while (i<j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(ci!=cj){
                return false;
            }
        }
        return true;
    }
    public String longestPalindrome1(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);

    }
}
