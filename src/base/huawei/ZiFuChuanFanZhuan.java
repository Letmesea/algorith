package base.huawei;

import java.util.Scanner;

public class ZiFuChuanFanZhuan {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            for(int i=str.length()-1;i>=0;i--){
                System.out.print(str.charAt(i));
            }
            System.out.println();
        }
    }
}
