package base.string;

import java.util.Random;

/**
 * @author Letmesea
 * @title: KmpAlgorithm
 * @projectName leetCode
 * @description: TODO
 * @date 2019/10/2319:46
 */
public class KmpAlgorithm {
    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
    public static int KMP(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0;
        int j = 0;
        int[] next = getNext(ps);
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Random random=new Random();
        long s = System.currentTimeMillis();
        KMP("ABACBCDHI","ABAB");
        long end = System.currentTimeMillis();
        long c = end-s;
        System.out.print(111);
    }
}
