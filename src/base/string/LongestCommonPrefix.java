package base.string;

/**
 * @author Letmesea
 * @title: LongestCommonPrefix
 * @projectName leetCode
 * @description: TODO
 * @date 2019/10/3110:23
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==1){return strs[0];}
        if(strs.length<1){return "";}
        StringBuilder sb = new StringBuilder();
        out:
        for (int i=0;i<strs[0].length();i++){
            for (int j=1;j<strs.length;){
                if(i<strs[j].length()&& strs[0].charAt(i)==strs[j].charAt(i)){
                    j++;
                }else{
                    break out;
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
    public static void main(String[] args){
        String ss[] = new String[]{"flower","flow","flight"};
        longestCommonPrefix1(ss);
        System.out.println(111);
    }
}
