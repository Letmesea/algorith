package base.string;

public class StrStr {
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty())return 0;
        int [] needles = getNext(needle);
        char haystacks[] = haystack.toCharArray();
        char needless[] = needle.toCharArray();
        int j=0,i=0;
        while (i<haystacks.length&&j<needless.length){
            if(j==-1||haystacks[i]==needless[j]){
                i++;j++;
            }else{
                j=needles[j];
            }
        }
        if(j==needless.length)
            return i-j;
        return -1;
    }
    public static int[] getNext(String needle){
        char c[] = needle.toCharArray();
        int res[] = new int[c.length];
        res[0]=-1;
        int k=-1;
        for(int i=0;i<c.length-1;){
            if(k==-1||c[i]==c[k]){
                res[++i] = ++k;
            }else{
                k = res[k];
            }
        }
        return res;
    }
    public static void main(String[] args){
        String str = "ABcd";
        str.indexOf("ABC");
        str.equals("123");
        int re = strStr("ABABC","ABC");
    }
}
