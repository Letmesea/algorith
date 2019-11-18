package base.string;

/**
 * @author Letmesea
 * @title: CountAndSay
 * @projectName leetCode
 * @description: TODO
 * @date 2019/10/3015:44
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        int i = 0, j = 1, k = 0;
        StringBuilder sb = n>1?new StringBuilder("11"):new StringBuilder("1");
        StringBuilder sb1;
        do {
            if(n>2){
                sb1 = new StringBuilder();
                for (; j < sb.length(); ) {
                    char ck = sb.charAt(k);
                    char cj = sb.charAt(j);
                    if (ck == cj) {
                        j++;
                        if(j==sb.length()){
                            sb1.append(j-k);
                            sb1.append(ck);
                        }
                    } else {
                        sb1.append(j - k);
                        sb1.append(ck);
                        k = j;j++;
                        if(j==sb.length()){
                            sb1.append(j-k);
                            sb1.append(sb.charAt(k));
                        }
                    }
                }
                sb = sb1;
            }
            i++;
            j = 1;
            k = 0;
        } while (i < n-2);
        return sb.toString();
    }

    public static void main(String[] args) {
        String res = countAndSay(2);
        System.out.println(res);
    }
}
