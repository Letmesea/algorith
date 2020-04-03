package base.huawei;

import java.util.Scanner;
//abac123,4abac
public class Commonstr {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int s=0,e=0;
            int ans = 0;
            for(int i=0;i<s2.length();i++){
                for(int j=i+1;j<=s2.length();j++){
                    String str = s2.substring(i,j);
                    if(s1.indexOf(str)!=-1&&j-i+1>ans){
                        s = i;e = j;
                        ans = j-i+1;
                    }
                }
            }
            System.out.println(s2.substring(s,e));
        }
    }
}
