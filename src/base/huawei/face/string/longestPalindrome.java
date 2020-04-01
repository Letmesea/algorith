package base.huawei.face.string;

public class longestPalindrome {
    /**
     * 暴力
     * @param s
     * @return
     */
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

    /**
     * 中心扩展
     * @param s
     * @return
     */
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
    /**
     * 中心扩展优化
     */
    public static String longestPalindrome2(String s){
        int strlen = s.length();
        if(strlen<2){
            return s;
        }
        int start = 0;
        int end = 0;
        int maxlen=0;
        boolean ispld[][] = new boolean[strlen][strlen];
        for(int r=1;r<strlen;r++){
            for(int l=0;l<r;l++){
                if(s.charAt(l)==s.charAt(r)&&(r-l<=2||ispld[l+1][r-1])){
                    ispld[l][r] = true;
                    if(r-l+1>maxlen){
                        start = l;
                        end = r;
                        maxlen = r-l+1;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
    public static void main(String[] args){
        System.out.println(longestPalindrome2("abcbdef"));
    }
}
