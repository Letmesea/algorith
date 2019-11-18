package base.string;

/**
 * @author Letmesea
 * @title: ReverseInt
 * @projectName leetCode
 * @description: TODO
 * @date 2019/10/1713:33
 */
public class ReverseInt {
    public static int reverse(int x) {
        if(x==0)return 0;
        char[] c =  String.valueOf(x).toCharArray();
        int s = c[0]=='-'?1:0;
        int j = c.length-1;
        while (j>s){
            if(c[j]!=c[s]){
                char t=c[s];
                c[s]=c[j];
                c[j]=t;
            }
            s++;
            j--;
        }
        j=0;
        StringBuilder sb = new StringBuilder();
        if(c[0]=='-'){
            sb.append('-');
        }
        while (c[j]=='-'||c[j]=='0'){j++;}
        for (int i=j;i<c.length;i++){
            sb.append(c[i]);
        }
        try {
            int res = Integer.valueOf(sb.toString());
            return res;
        }catch (Exception e){
            return 0;
        }
    }
    public static void main(String[] args){
        reverse(1534236469);
    }
}
