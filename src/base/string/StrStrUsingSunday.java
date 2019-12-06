package base.string;

/**
 * @author Letmesea
 * @title: StrStrUsingSunday
 * @projectName leetCode
 * @description: 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
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
