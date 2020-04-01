package base.huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class WuChongFuZiFuZuiChangZiChuan {

        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int ans = 0, i = 0, j = 0;
            while (i < n && j < n) {
                // try to extend the range [i, j]
                if (!set.contains(s.charAt(j))){
                    set.add(s.charAt(j++));
                    ans = Math.max(ans, j - i);
                }
                else {
                    set.remove(s.charAt(i++));
                }
            }
            return ans;
        }

    /**
     * 不含重复字符最长子串
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0, i = 0, j = 0;
        for(;j<n;j++) {
            if (map.containsKey(s.charAt(j))) {
                i = map.get(s.charAt(j))+1>i?map.get(s.charAt(j))+1:i;
            }
            ans = j-i+1>ans?j-i+1:ans;
            map.put(s.charAt(j),j);
        }

        return ans;
    }

}
