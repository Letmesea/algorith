package base.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ErJinZhiZhong1DeGeShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int count1 = 0;
            while (n!=0){
                if(n%2==1){
                    count1++;
                }
                n = n/2;
            }
            System.out.println(count1);
        }
    }
}
