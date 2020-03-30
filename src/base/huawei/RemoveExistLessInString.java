package base.huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RemoveExistLessInString {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int cs[] = new int[26];
            String str = scanner.nextLine();
            char carr[] = str.toCharArray();
            int min = Integer.MAX_VALUE;
            for(int i=0;i<carr.length;i++){
                cs[carr[i]-97]++;
                min = min>cs[carr[i]-97]?cs[carr[i]-97]:min;
            }
            for(int i=0;i<cs.length;i++){
                if(min==cs [i]){
                    str = str.replaceAll(String.valueOf((char)(i+97)),"");
                }
            }
            System.out.println(str);
        }

    }
}
