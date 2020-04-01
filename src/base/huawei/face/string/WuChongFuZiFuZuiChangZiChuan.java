package base.huawei.face.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WuChongFuZiFuZuiChangZiChuan {
    /**
     *最长不重复子串,hashset
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 最长不重复子串,hashmap
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0, i = 0, j = 0;
        while ( j < n) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i,map.get(s.charAt(j))+1);
            }
            ans = Math.max(j-i+1,i);
            map.put(s.charAt(j),j);
            j++;
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring1("abcbdef"));
    }
}
