package base.huawei;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String tstr = sc.nextLine();
            String pstr = sc.nextLine();
            int idx = tstr.indexOf(pstr);
            if(idx!=-1){
                System.out.println(idx+1);
            }else{
                System.out.println("NO");
            }
        }
    }
}
