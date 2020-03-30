package base.huawei;

import java.util.Scanner;

public class ShuZiDianDao {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
/*            String n = sc.nextLine();
            StringBuilder sb = new StringBuilder(n);
            System.out.println(sb.reverse().toString());*/
            int n = sc.nextInt();
            if(n==0){
                System.out.println(n);
            }else{
                while(n!=0){
                    System.out.print(n%10);
                    n = n/10;
                }
                System.out.println();
            }

        }
    }
}
