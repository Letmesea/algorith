package base.huawei;

import java.util.Scanner;

public class JuZiNiZhuan {
    public static void main(String[] args){
        JuZiNiZhuan juZiNiZhuan = new JuZiNiZhuan();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            juZiNiZhuan.reverse(str);
        }
    }
    public String reverse(String sentence){
        String [] sarr = sentence.trim().split(" ");
        for (int i = sarr.length - 1; i >= 0; i--) {
            if (i > 0)
                System.out.print(sarr[i] + " ");
            else
                System.out.print(sarr[i]);
        }
        System.out.println();
        return null;
    }
}
