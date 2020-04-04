package base.huawei.face.string;

import java.util.Scanner;
//MyNameIsTom
//yMemaNsImoT
//MMyN
//MMNy
//LowLL
//woLLL
/**
 * 句子中单词翻转
 */
public class JuZiZhongDanCiFanZhuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if(str.length()<2){
                System.out.println(str);
                continue;
            }
            int i=0,j=1;
            for(;j<str.length();){
                if(str.charAt(j)>='A'&&str.charAt(j)<='Z'){
                    StringBuilder stringBuilder = new StringBuilder(str.substring(i,j));
                    System.out.print(stringBuilder.reverse().toString());
                    i=j;j++;
                }else{
                    j++;
                }
            }
            StringBuilder stringBuilder = new StringBuilder(str.substring(i,j));
            System.out.print(stringBuilder.reverse().toString());
            System.out.println();
        }
    }
}
