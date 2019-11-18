package base.string;

/**
 * @author Letmesea
 * @title: StrStrUsingSunday
 * @projectName leetCode
 * @description: TODO
 * @date 2019/10/2814:04
 */
public class StrStrUsingSunday {
    public static int strStr(String haystack, String needle) {
        char hs[] = haystack.toCharArray();
        char ns[] = needle.toCharArray();
        int i = 0, j = 0, hl = hs.length, nl = ns.length;
        if (needle.isEmpty()) {
            return 0;
        }
        if (hl < nl) {
            return -1;
        }
        while (i <= hl - nl + j) {
            if (hs[i] != ns[j]) {
                if (i == hl - nl + j) {
                    return -1;
                }
                int index = -1;
                for (int i1 = nl - 1; i1 >= 0; i1--) {
                    if (hs[i + nl - j] == ns[i1]) {
                        index = i1;
                        break;
                    }
                }
                if (index == -1) {
                    i = i + nl - j + 1;
                    j = 0;
                } else {
                    i = i + nl - j - index;
                    j = 0;
                }
            } else {
                if (j == nl - 1) {
                    return i - j;
                }
                i++;
                j++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String hs = "aaa";
        String ns = "aaa";
        int res = strStr(hs, ns);
        System.out.println(111);
    }
}
